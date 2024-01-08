; @file main.asm
; @author Alan Davide Bovo (alandavide.bovo.stud@ispascalcomandini.it)
; @date 2024-01-08
; Compile with: nasm -f elf64 -o main.o main.asm && ld -s -o challenge main.o

section .data
    inputMsg db "Enter a number: ", 0x0
    inputMsgLen equ $ - inputMsg
    flagName db "flag.txt", 0x0
    flagNameLen equ $ - flagName
    leak db "The leak is: ", 0x0
    leakLen equ $ - leak

section .text
    global _start

    readFlag:
        mov rax, 0x2            ; sys_open
        lea rdi, [flagName]     ; filename, flag.txt
        xor rsi, rsi            ; flags, O_RDONLY
        syscall
        ret                     ; return to the address on the stack

    strangeFun:
        mov rax, rsp            ; rax = rsp
        add rax, 0x8            ; rax = rax + 8
        add rdi, 13             ; rdi = rdi + 13 (ROT13)
        push rax                ; push rax on the stack
        mov rax, rdi            ; dividend
        xor edx, edx            ; Clear edx (upper bits of dividend for 64-bit division)
        mov ecx, 0x19           ; divisor = 25
        div ecx                 ; rax = rax / rbx
        mov rdi, rdx            ; rdi = rdx = rax % rbx
        push rdi                ; push rdi on the stack

        mov rax, 0x1            ; sys_write
        xor rdi, rdi            ; stdout
        lea rsi, [leak]         ; message
        mov rdx, leakLen        ; message length
        syscall
        
        pop rdi                 ; pop rdi from the stack
        pop rax                 ; pop rax from the stack
        lea rsi, byte [rax + rdi]    ; message
        mov rax, 0x1            ; sys_write
        xor rdi, rdi            ; stdout
        mov rdx, 0x1            ; message length
        syscall
        ret

    _start:
        mov rax, 0x1            ; sys_write
        mov rdi, 0x1            ; stdout
        lea rsi, [inputMsg]     ; message
        mov rdx, inputMsgLen    ; message length
        syscall

        push r12                ; push r12 on the stack
        push r13                ; push r13 on the stack
        sub rsp, 0x2            ; allocate 2 bytes on the stack

        xor rax, rax            ; sys_read
        mov rdi, 0x0            ; stdin
        lea rsi, [rsp]          ; buffer address
        mov rdx, 0x2            ; buffer size
        syscall

        xor r12, r12            ; r12 = 0
        check:
            ; assert value is valid integer
            cmp byte [rsp], 0xa     ; '\n'
            je continue             ; continue if value == '\n'
            cmp byte [rsp], 0x0     ; '\0'
            je continue             ; continue if value == '\0'
            cmp byte [rsp], 0x30    ; '0'
            jl exit                 ; exit if value < 0
            cmp byte [rsp], 0x39    ; '9'
            jg exit                 ; exit if value > 9
            sub byte [rsp], 0x30    ; value = value - '0'
            ; r12 *= 10
            mov r13, r12            ; r13 = r12
            shl r12, 0x3            ; r12 = r12 << 3
            shl r13, 0x1            ; r13 = r13 << 1
            add r12, r13            ; r12 = r12 + r13
            add r12b, byte [rsp]     ; r12 = r12 + value
            inc rsp                 ; increment rsp
            jmp check

        continue:
        call readFlag

        sub rsp, 0x1a           ; allocate 26 bytes on the stack
        mov rdi, rax            ; fd of the flag.txt file
        xor rax, rax            ; sys_read
        lea rsi, [rsp]          ; buffer address
        mov rdx, 0x19           ; buffer size
        syscall
        
        mov byte [rsp + 0x19], 0x0 ; null terminate the string
        mov rdi, r12            ; rdi = index of the flag string
        xor rsi, rsi            ; rsi = 0
        call strangeFun
        add rsp, 0x1a           ; deallocate 26 bytes from the stack
        pop r13                 ; pop r12 from the stack
        pop r12                 ; pop r13 from the stack
        call _exit
    
    exit:
        call _exit
    _exit:
        mov rax, 0x3c           ; sys_exit
        xor rdi, rdi            ; exit code
        syscall
/**
 * @file main.c
 * @author Alan Davide Bovo (alandavide.bovo.stud@ispascalcomandini.it)
 * @date 2024-01-04
 * Compile with: gcc main.c -o main
 */
#include<stdio.h>
#include<stdbool.h>
#include<string.h>

// la firma vera: 4v3v1_v0gl14 [di reversare ...] (l'ho accorciata per comodita')
bool checkSignature(char *buffer){
    if(strlen(buffer) != 12)    // la firma vera e' lunga 12 caratteri
        return false;

    if(buffer[0] * buffer[0] - 242 * buffer[0] != -9880)
        return false;
    if(buffer[1] * buffer[1] + 3 * buffer[1] != 14278)
        return false;
    if(buffer[2] * buffer[2] - 54 * buffer[2] != -153)
        return false;
    if(buffer[3] * buffer[3] - 61 * buffer[3] != 6726)
        return false;
    if(buffer[4] * buffer[4] - 2 * buffer[4] != 2303)
        return false;
    if(buffer[5] * buffer[5] + 101 * buffer[5] != 18620)
        return false;
    if(buffer[6] * buffer[6] + 90 * buffer[6] != 24544)
        return false;
    if(buffer[7] * buffer[7] - 72 * buffer[7] != -1152)
        return false;
    if(buffer[8] * buffer[8] + 25 * buffer[8] != 13184)
        return false;
    if(buffer[9] * buffer[9] - 260 * buffer[9] != -16416)
        return false;
    if(buffer[10] * buffer[10] - 526 * buffer[10] != -23373)
        return false;
    if(buffer[11] * buffer[11] + 425 * buffer[11] != 24804)
        return false;
    return true;    // se non e' stato trovato nessun errore, la firma e' corretta
}

int main(){
    char buffer[50];                            // buffer per la lettura della firma
    fputs("Insert the secret code: ", stdout);  // stampa del messaggio di richiesta
    fgets(buffer, 50, stdin);                   // lettura della firma

    if(buffer[strlen(buffer) - 1] == '\n')      // rimozione del carattere '\n' finale
        buffer[strlen(buffer) - 1] = '\0';

    if(checkSignature(buffer))
        fputs("Congrats! You have found the secret code!", stdout); // stampa del messaggio di successo
    else
        fputs("Sorry, the secret code is wrong!", stdout);  // stampa del messaggio di errore
}
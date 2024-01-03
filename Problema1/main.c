/**
 * @file main.c
 * @author Alan Davide Bovo (alandavide.bovo.stud@ispascalcomandini.it)
 * @date 2024-01-03
 * Compile with: gcc main.c -o main
 */
#include<stdio.h>
#include<stdbool.h>
#include<string.h>

const char trueSignature[31] = "c0d1c3segr3t0_4bbast4n5a_lung0\0";

bool checkSignature(char *signature){
    if(strlen(signature) != strlen(trueSignature)){ // se la lunghezza della stringa inserita è diversa da quella corretta, ritorno false
        return false;
    }
    for(int i=0; i<sizeof(signature); i++){
        if(signature[i] != trueSignature[i]){ // se un carattere della stringa inserita è diverso da quello corretto, ritorno false
            return false;
        }
    }
    return true; // se la stringa inserita è uguale a quella corretta, ritorno true
}

int main(){
    char signature[50];                         // buffer in qui memorizzo la stringa inserita dall'utente
    fputs("Insert the secret code: ", stdout);  // stampo il messaggio di richiesta
    fgets(signature, 50, stdin);                // leggo al più 50 caratteri da stdin
    if(signature[strlen(signature)-1] == '\n')  // se l'ultimo carattere è un newline, lo sostituisco con un carattere nullo
        signature[strlen(signature)-1] = '\0';
    if(checkSignature(signature))               // controllo se la stringa inserita è uguale a quella corretta
        fputs("Congrats! You have found the secret code!", stdout); // se sì, stampo il messaggio di congratulazioni
    else
        fputs("Sorry, the secret code is wrong!", stdout); // altrimenti stampo il messaggio di errore
    return 0;
}
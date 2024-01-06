/**
 * @file main.c
 * @author Alan Davide Bovo (alandavide.bovo.stud@ispascalcomandini.it)
 * @date 2024-01-06
 * Compile with: gcc main.c -o main -lssl -lcrypto
 */
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<time.h>
#include<openssl/sha.h>

int main(){
    srand(time(NULL));                                  // Inizializzo randomicamente il generatore
    int key[1] = {rand() % 256};                        // Genero un numero randomico tra 0 e 255
    unsigned char *hash = SHA256((char *)key, 1, NULL); // Calcolo l'hash della chiave

    FILE *fp = fopen("flag.txt", "r");                  // Apro il file flag.txt
    if(fp == NULL){                                     // Controllo se il file esiste
        printf("Error, the file doesn't exist!\n");     // Stampo un messaggio di errore se non esiste
        exit(1);
    }
    char flag[32];                          // Dichiaro una stringa di 32 caratteri
    fgets(flag, 32, fp);                    // Leggo la flag dal file
    fclose(fp);                             // Chiudo il file

    fputs("The encrypted flag is: ", stdout);// Stampo un messaggio
    for(int i=0; i<strlen(flag); i++){      // Per ogni carattere della flag
        printf("%02x", flag[i] ^ hash[i]);  // Stampo il carattere XORato con l'hash
    }
    return 0;
}

/**
 * @file main.c
 * @author Alan Davide Bovo (alandavide.bovo.stud@ispascalcomandini.it)
 * @date 2024-01-05
 * Compile with: gcc main.c -o main
 */
#include<stdlib.h>
#include<stdio.h>

int main(){
    srand(0); // inizializzazione del generatore di numeri casuali
    fputs("Welcome to the guessing game!\n", stdout); // stampa del messaggio di benvenuto
    fputs("You must guess 10 numbers that I'm thinking between 0 and 99\n", stdout);
    for(int i=0; i<10; i++){
        int guess, number = rand()%100;                 // generazione del numero casuale
        printf("Can you guess the %d number? ", i+1);   // stampa del messaggio di richiesta
        scanf("%d", &guess);                            // lettura del numero inserito dall'utente
        if(guess != number)                             // confronto tra il numero inserito e quello generato
            break;
        if(i == 9){                                     // se l'utente ha indovinato tutti i numeri
            fputs("Congratulations! You won the game!\n", stdout);
            return 0;
        }
    }
    fputs("You lost the game!\n", stdout); // stampa del messaggio di sconfitta
}
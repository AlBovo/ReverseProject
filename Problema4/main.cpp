/**
 * @file main.cpp
 * @author Alan Davide Bovo (alandavide.bovo.stud@ispascalcomandini.it)
 * @date 2024-01-05
 * Compile with: g++ main.cpp -o main
 */
#include<cstdlib>
#include<iostream>

using namespace std;

int main(){
    srand(0); // inizializzazione del generatore di numeri casuali
    cout << "Welcome to the guessing game!" << endl; // stampa messaggio di benvenuto
    cout << "You must guess 10 numbers that I'm thinking between 0 and 99" << endl;
    for(int i=0; i<10; i++){
        int guess, number = rand()%100;                     // generazione del numero casuale
        cout << "Can you guess the " << i+1 << " number? "; // stampa del messaggio di richiesta
        cin >> guess;                                       // lettura del numero inserito dall'utente
        if(guess != number)                                 // verifica se il numero inserito è corretto
            break;
        if(i == 9){                                         // verifica se è l'ultimo numero
            cout << "Congratulations! You won the game!" << endl;
            return 0;
        }
    }
    cout << "You lost the game!" << endl; // stampa del messaggio di sconfitta
}
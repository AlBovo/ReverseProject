/**
 * @file main.cpp
 * @author Alan Davide Bovo (alandavide.bovo.stud@ispascalcomandini.it)
 * @date 2024-01-06
 * Compile with: g++ main.cpp -o main -lssl -lcrypto
 */
#include<cstdlib>
#include<ctime>
#include<iostream>
#include<string>
#include<fstream>
#include<openssl/sha.h>

using namespace std;

// Circa copiata dal file main.c
ifstream flagIN("flag.txt");

int main(){
    srand(time(NULL));                                          // Inizializzo randomicamente il generatore
    int key[1] = {rand() % 256};                                // Genero un numero randomico tra 0 e 255
    unsigned char *hash = SHA256((unsigned char *)key, 1, NULL);// Calcolo l'hash della chiave
    string flag; flagIN >> flag;            // Leggo la flag
    cout << "The encrypted flag is: ";      // Stampo il messaggio
    for(int i = 0; i < flag.length(); i++)  // Per ogni carattere della flag
        printf("%02x", flag[i] ^ hash[i]);  // Stampo il carattere XORato con il primo byte dell'hash
}
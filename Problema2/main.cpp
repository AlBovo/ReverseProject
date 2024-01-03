/**
 * @file main.cpp
 * @author Alan Davide Bovo (alandavide.bovo.stud@ispascalcomandini.it)
 * @date 2024-01-03
 * Compile with: g++ main.cpp -o main
 */
#include<string>
#include<iostream>

using namespace std;

// stringa decifrata: ReV3r53_1s_4w3s0m3
const string key = "*7^tVr4FZ#7S4RFNd2"; // chiave di cifratura
const string encrypted = "xR\x08G$G\x07\x19kPhgCa5~\t\x01"; // stringa cifrata

bool checkSignature(string signature){
    if(signature.length() != key.length()){ // se la lunghezza della stringa è diversa da quella della chiave
        return false;
    }
    for(int i = 0; i < key.length(); i++){
        if((int)(signature[i] ^ key[i]) != encrypted[i]){ // se il carattere della stringa XOR il carattere della chiave è diverso dal carattere della stringa cifrata
            return false;
        }
    }
    return true;
}

int main(){
    string signature;                   // stringa da inserire
    cout << "Insert the secret code: "; // stampa della richiesta a video
    cin >> signature;                   // lettura dell'input la stringa inserita dall'utente
    if(checkSignature(signature))
        cout << "Congrats! You have found the secret code!" << endl; // stampa del messaggio di successo
    else
        cout << "Sorry, the secret code is wrong!" << endl; // stampa del messaggio di errore
    return 0;
}
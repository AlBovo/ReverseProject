/**
 * @file main.cpp
 * @author Alan Davide Bovo (alandavide.bovo.stud@ispascalcomandini.it)
 * @date 2024-01-03
 * Compile with: g++ main.cpp -o main
 */
#include<string>
#include<iostream>

using namespace std;

const string trueSignature = "c0d1c3segr3t0_4bbast4n5a_lung0"; // stringa che contiene la firma corretta

bool checkSignature(string signature){
    if(signature.length() != trueSignature.length()){ // se la lunghezza della stringa è diversa da quella della chiave
        return false;
    }
    for(int i = 0; i < signature.length(); i++){
        if(signature[i] != trueSignature[i]){ // se un carattere della stringa inserita è diverso da quello corretto, ritorno false
            return false;
        }
    }
    return true;
}

int main(){
    string signature;  // stringa da inserire
    cout << "Insert the secret code: "; cin >> signature; // stampa della richiesta a video e lettura dell'input
    if(checkSignature(signature)) // se la firma è corretta
        cout << "Congrats! You have found the secret code!" << endl;
    else
        cout << "Sorry, the secret code is wrong!" << endl;
    return 0;
}
/**
 * @file main.cs
 * @author Alan Davide Bovo (alandavide.bovo.stud@ispascalcomandini.it)
 * @date 2024-01-03
 * Compile with: mcs -out:main.exe main.cs
 */
using System;

public class MainClass{
    // firma decifrata: ReV3r53_1s_4w3s0m3
    private const string key = "*7^tVr4FZ#7S4RFNd2"; // chiave di cifratura
    private const string encrypted = "xR\x08G$G\x07\x19kPhgCa5~\t\x01"; // firma cifrata

    private static bool checkSignature(string signature){   // funzione per il controllo della firma
        if(signature.Length != key.Length){                 // controllo della lunghezza della stringa
            return false;
        }
        for(int i = 0; i < signature.Length; i++){          // controllo carattere per carattere
            if((signature[i] ^ key[i]) != encrypted[i]){    // confronto tra i caratteri
                return false;
            }
        }
        return true; // se non sono stati trovati errori, la firma è corretta
    }

    public static void Main(string[] args){
        Console.Write("Insert the secret code: ");  // stampa del messaggio di input
        string signature = Console.ReadLine();      // lettura della stringa inserita dall'utente
        if(checkSignature(signature)){              // controllo della stringa inserita
            Console.WriteLine("Congrats! You have found the secret code!"); // stampa del messaggio di successo
        }else{
            Console.WriteLine("Sorry, the secret code is wrong!");          // stampa del messaggio di errore
        }
    }
}
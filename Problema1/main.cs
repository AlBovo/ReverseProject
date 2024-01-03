/**
 * @file main.cs
 * @author Alan Davide Bovo (alandavide.bovo.stud@ispascalcomandini.it)
 * @date 2024-01-03
 * Compile with: mcs -out:main.exe main.cs
 */
using System;

public class MainClass{
    private const string trueSignature = "c0d1c3segr3t0_4bbast4n5a_lung0"; // firma corretta

    private static bool checkSignature(string signature){   // funzione per il controllo della firma
        if(signature.Length != trueSignature.Length){       // controllo della lunghezza della stringa
            return false;
        }
        for(int i = 0; i < signature.Length; i++){          // controllo carattere per carattere
            if(signature[i] != trueSignature[i]){           // confronto tra i caratteri
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
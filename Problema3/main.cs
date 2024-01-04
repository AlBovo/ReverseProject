/**
 * @file main.cs
 * @author Alan Davide Bovo (alandavide.bovo.stud@ispascalcomandini.it)
 * @date 2024-01-04
 * Compile with: mcs -out:main.exe main.cs
 */
using System;

// la firma vera: 4v3v1_v0gl14 [di reversare ...] (l'ho accorciata per comodita')
public class MainClass {
    public static bool checkSignature(string secretCode){
        if(secretCode.Length != 12)    // la firma vera e' lunga 12 caratteri
            return false;

        if(secretCode[0] * secretCode[0] - 242 * secretCode[0] != -9880)
            return false;
        if(secretCode[1] * secretCode[1] + 3 * secretCode[1] != 14278)
            return false;
        if(secretCode[2] * secretCode[2] - 54 * secretCode[2] != -153)
            return false;
        if(secretCode[3] * secretCode[3] - 61 * secretCode[3] != 6726)
            return false;
        if(secretCode[4] * secretCode[4] - 2 * secretCode[4] != 2303)
            return false;
        if(secretCode[5] * secretCode[5] + 101 * secretCode[5] != 18620)
            return false;
        if(secretCode[6] * secretCode[6] + 90 * secretCode[6] != 24544)
            return false;
        if(secretCode[7] * secretCode[7] - 72 * secretCode[7] != -1152)
            return false;
        if(secretCode[8] * secretCode[8] + 25 * secretCode[8] != 13184)
            return false;
        if(secretCode[9] * secretCode[9] - 260 * secretCode[9] != -16416)
            return false;
        if(secretCode[10] * secretCode[10] - 526 * secretCode[10] != -23373)
            return false;
        if(secretCode[11] * secretCode[11] + 425 * secretCode[11] != 24804)
            return false;
        return true;    // se non e' stato trovato nessun errore, la firma e' corretta
    }
    public static void Main(string[] args){
        Console.Write("Insert the secret code: ");  // chiede all'utente di inserire la firma
        string secretCode = Console.ReadLine();     // legge la firma inserita dall'utente

        if(checkSignature(secretCode))              // controlla se la firma e' corretta
            Console.WriteLine("Congrats! You have found the secret code!");
        else
            Console.WriteLine("Sorry, the secret code is wrong!");
    }
}
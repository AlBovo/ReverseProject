/**
 * @file main.cs
 * @author Alan Davide Bovo (alandavide.bovo.stud@ispascalcomandini.it)
 * @date 2024-01-06
 * Compile with: mcs -out:main.exe main.cs
 */
using System;
using System.Security.Cryptography;
using System.IO;
using System.Text;

public class MainClass {
    // https://www.c-sharpcorner.com/article/compute-sha256-hash-in-c-sharp/
    static byte[] ComputeSha256Hash(string rawData){
        // Create a SHA256
        using (SHA256 sha256Hash = SHA256.Create()){
            // ComputeHash - returns byte array
            byte[] bytes = sha256Hash.ComputeHash(Encoding.UTF8.GetBytes(rawData));
            return bytes;
        }
    }
    public static void Main(string[] args){
        Random rnd = new Random();                          // Generatore di numeri casuali
        string flag = File.ReadAllText("flag.txt").Trim();  // Legge il flag dal file
        int n = rnd.Next(256);                              // Genera un numero casuale tra 0 e 255
        // Diverso da C/C++ poichè l'hash è del numero e non della sua rappresentazione in ASCII
        byte[] hash = ComputeSha256Hash(n.ToString());      // Calcola l'hash del numero
        Console.Write("The encrypted flag is: ");           // Stampo il messaggio
        for(int i=0; i<hash.Length; i++){
            Console.Write((hash[i] ^ flag[i]).ToString("x2"));  // Stampa la flag criptata in esadecimale
        }
    }
}
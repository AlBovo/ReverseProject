/**
 * @file main.cs
 * @author Alan Davide Bovo (alandavide.bovo.stud@ispascalcomandini.it)
 * @date 2024-01-05
 * Compile with: mcs -out:main.exe main.cs
 */
using System;

public class MainClass {
    public static void Main(string[] args){
        Random rnd = new Random(0); // inizializzo il random con 0 per avere sempre gli stessi numeri
        Console.WriteLine("Welcome to the guessing game!"); // welcome message
        Console.WriteLine("You must guess 10 numbers that I'm thinking between 0 and 99");

        for(int i=0; i<10; i++){
            int guess, number = rnd.Next(100);                  // genero un numero random
            Console.Write($"Can you guess the {i+1} number? "); // chiedo all'utente di indovinare il numero
            // pls non rompere [il cazzo con i try catch IDEA DI GITHUB COPILOT]
            guess = int.Parse(Console.ReadLine());              // leggo il numero inserito dall'utente
            if(guess != number)                                 // controllo se il numero inserito è uguale a quello generato
                break;
            if(i == 9){                                         // controllo se è l'ultimo numero
                Console.WriteLine("Congratulations! You won the game!");
                return;
            }
        }
        Console.WriteLine("You lost the game!"); // se non è l'ultimo numero, l'utente ha perso
    }
}
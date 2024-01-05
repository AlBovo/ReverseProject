/**
 * @file challenge.java
 * @author Alan Davide Bovo (alandavide.bovo.stud@ispascalcomandini.it)
 * @date 2024-01-05
 * Compile with: javac Problema4/challenge.java
 * Run with: java Problema4.challenge
 */
package Problema4;

import java.util.Random;
import java.util.Scanner;

public class challenge {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // creo un oggetto per leggere da tastiera
        Random rand = new Random();             // creo un oggetto per generare numeri casuali

        System.out.println("Welcome to the guessing game!"); // stampo il messaggio di benvenuto
        System.out.println("You must guess 10 numbers that I'm thinking between 0 and 99");
        rand.setSeed(0); // imposto il seed del generatore di numeri casuali a 0
        
        for(int i=0; i<10; i++){
            int guess;                      // creo una variabile per memorizzare il numero inserito dall'utente
            int number = rand.nextInt(100); // genero un numero casuale tra 0 e 99
            System.out.print(String.format("Can you guess the %d number?  ", i+1)); // stampo il messaggio per l'utente
            guess = input.nextInt();        // leggo il numero inserito dall'utente
            if(guess != number)             // se il numero inserito dall'utente e' diverso dal numero casuale
                break;
            if(i == 9){                     // se e' l'ultimo numero da indovinare
                System.out.println("Congratulations! You won the game!");
                input.close();
                return;
            }
        }
        System.out.println("You lost the game!"); // se l'utente non ha indovinato tutti i numeri
        input.close();
    }
}
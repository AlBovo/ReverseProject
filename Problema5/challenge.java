/**
 * @file challenge.java
 * @author Alan Davide Bovo (alandavide.bovo.stud@ispascalcomandini.it)
 * @date 2024-01-06
 * Compile with: javac Problema5/challenge.java
 * Run with: java Problema5.challenge
 */
package Problema5;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class challenge {
    private static byte[] calculateSHA256(String input) { // Funzione per calcolare l'SHA-256
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes());
            return hash;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void main(String[] args) {
        String flag = ""; // Stringa per contenere la flag
        try {
            flag = new String(Files.readAllBytes(Paths.get("flag.txt")));   // Leggo il flag dal file
        } catch (Exception e) {   // Errori vari
            System.out.println(e.getMessage()); // Stampo l'errore
            System.exit(1);                     // Esco con errore
        }

        Random rnd = new Random();                                              // Inizializzo il generatore di numeri casuali
        byte[] hash = calculateSHA256(String.format("%d", rnd.nextInt(256)));   // Come in C#
        System.out.print("The encrypted flag is: ");                            // Stampo il messaggio
        for(int i=0; i<hash.length; i++) {
            System.out.printf("%02x", (hash[i] ^ flag.codePointAt(i)) & 0xFF);  // Stampo il risultato in esadecimale
        }
    }
}
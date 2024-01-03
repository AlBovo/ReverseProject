/**
 * @file challenge.java
 * @author Alan Davide Bovo (alandavide.bovo.stud@ispascalcomandini.it)
 * @date 2024-01-03
 * Compile with: javac -g:none Problema1/challenge.java
 * Run with: java Problema1.challenge
 */

package Problema1;

public class challenge {
    private final static String trueSignature = "c0d1c3segr3t0_4bbast4n5a_lung0"; // chiave segreta

    public static boolean checkSignature(String signature) {    // funzione che controlla la chiave
        if(signature.length() != trueSignature.length()){       // se la lunghezza della chiave è diversa da quella della chiave segreta
            return false;
        }
        for(int i = 0; i < signature.length(); i++){            // controllo ogni carattere della chiave
            if(signature.charAt(i) != trueSignature.charAt(i)){ // se la chiave è diversa da quella segreta
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        if(args.length != 1) {          // se il numero di argomenti è diverso da 1
            System.out.println("Usage: java Problema1.challenge <signature>");
            System.exit(1);
        }
        String signature = args[0];     // prendo la chiave
        
        if(checkSignature(signature))   // se la chiave è corretta
            System.out.println("Congrats! You have found the secret code!");
        else
            System.out.println("Sorry, the secret code is wrong!");
    }
}
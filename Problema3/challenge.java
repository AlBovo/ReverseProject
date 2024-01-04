/**
 * @file challenge.java
 * @author Alan Davide Bovo (alandavide.bovo.stud@ispascalcomandini.it)
 * @date 2024-01-04
 * Compile with: javac Problema3/challenge.java
 * Run with: java Problema3.challenge
 */
package Problema3;

// la firma vera: 4v3v1_v0gl14 [di reversare ...] (l'ho accorciata per comodita')
public class challenge {
    public static boolean checkSignature(String signature) {
        if(signature.length() != 12)    // la firma vera e' lunga 12 caratteri
            return false;

        // grazie copilot per questo avermi tradotto il codice C -> Java
        if(signature.codePointAt(0) * signature.codePointAt(0) - 242 * signature.codePointAt(0) != -9880)
            return false;
        if(signature.codePointAt(1) * signature.codePointAt(1) + 3 * signature.codePointAt(1) != 14278)
            return false;
        if(signature.codePointAt(2) * signature.codePointAt(2) - 54 * signature.codePointAt(2) != -153)
            return false;
        if(signature.codePointAt(3) * signature.codePointAt(3) - 61 * signature.codePointAt(3) != 6726)
            return false;
        if(signature.codePointAt(4) * signature.codePointAt(4) - 2 * signature.codePointAt(4) != 2303)
            return false;
        if(signature.codePointAt(5) * signature.codePointAt(5) + 101 * signature.codePointAt(5) != 18620)
            return false;
        if(signature.codePointAt(6) * signature.codePointAt(6) + 90 * signature.codePointAt(6) != 24544)
            return false;
        if(signature.codePointAt(7) * signature.codePointAt(7) - 72 * signature.codePointAt(7) != -1152)
            return false;
        if(signature.codePointAt(8) * signature.codePointAt(8) + 25 * signature.codePointAt(8) != 13184)
            return false;
        if(signature.codePointAt(9) * signature.codePointAt(9) - 260 * signature.codePointAt(9) != -16416)
            return false;
        if(signature.codePointAt(10) * signature.codePointAt(10) - 526 * signature.codePointAt(10) != -23373)
            return false;
        if(signature.codePointAt(11) * signature.codePointAt(11) + 425 * signature.codePointAt(11) != 24804)
            return false;
        return true;    // se non e' stato trovato nessun errore, la firma e' corretta
    }
    public static void main(String[] args) {
        if(args.length != 1) { // se non e' stato passato un argomento
            System.out.println("Usage: java challenge <signature>");
            return;
        }
        String buffer = args[0]; // prendo la firma passata come argomento
        
        if(checkSignature(buffer)) // controllo se la firma e' corretta
            System.out.println("Congrats! You have found the secret code!"); // se e' corretta, stampo il codice segreto
        else
            System.out.println("Sorry, the secret code is wrong!"); // altrimenti stampo che la firma e' sbagliata
    }
}
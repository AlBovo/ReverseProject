/**
 * @file challenge.java
 * @author Alan Davide Bovo (alandavide.bovo.stud@ispascalcomandini.it)
 * @date 2024-01-03
 * Compile with: javac -g:none Problema2/challenge.java
 * Run with: java Problema2.challenge
 */
package Problema2;

// stringa decifrata: ReV3r53_1s_4w3s0m3
public class challenge {
    private final static String key = "*7^tVr4FZ#7S4RFNd2"; // chiave di cifratura
    private final static String encrypted = "xR\u0008G$G\u0007\u0019kPhgCa5~\t\u0001"; // testo cifrato
    
    public static boolean checkSignature(String signature){
        if(signature.length() != key.length()){
            return false; // se la lunghezza della chiave è diversa da quella della chiave di controllo
        }
        for(int i = 0; i < key.length(); i++){
            if((signature.charAt(i) ^ key.charAt(i)) != encrypted.charAt(i)){
                return false; // se il carattere della chiave è diverso da quello della chiave di controllo
            }
        }
        return true;
    }
    public static void main(String[] args){
        if(args.length != 1) {          // se il numero di argomenti è diverso da 1
            System.out.println("Usage: java Problema2.challenge <signature>");
            System.exit(1);
        }
        String signature = args[0];     // prendo la chiave

        if(checkSignature(signature))   // se la chiave è corretta
            System.out.println("Congrats! You have found the secret code!");
        else
            System.out.println("Sorry, the secret code is wrong!");
    }
}

/**
 * @file challenge.kt
 * @author Alan Davide Bovo (alandavide.bovo.stud@ispascalcomandini.it)
 * @date 2024-01-06
 * Compile with: kotlinc challenge.kt -include-runtime -d challenge.jar
 * Run with: java -jar challenge.jar
 */
import java.io.File
import java.util.Random
import java.security.MessageDigest

fun calculateSHA256(input: String): ByteArray { // Funzione per calcolare l'hash SHA256 di una stringa
    val md = MessageDigest.getInstance("SHA-256")
    val hashBytes = md.digest(input.toByteArray())
    return hashBytes
}

fun main() {
    val flagFile = File("flag.txt") // Apro il file flag.txt
    val flag = flagFile.readText()  // Leggo il contenuto del file flag.txt
    
    val rnd = Random()              // Creo un oggetto Random
    val hash = calculateSHA256("${rnd.nextInt(256)}")   // Calcolo l'hash SHA256 di un numero casuale
    print("The encrypted flag is: ")                    // Stampo il messaggio
    for(i in 0..31) {
        print("%02x".format((hash[i].toInt() xor flag[i].code) and 0xFF)) // Cripto la flag con l'hash calcolato
    }
}
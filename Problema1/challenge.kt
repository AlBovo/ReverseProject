/**
 * @file challenge.kt
 * @author Alan Davide Bovo (alandavide.bovo.stud@ispascalcomandini.it)
 * @date 2024-01-03
 * Compile with: kotlinc challenge.kt -include-runtime -d challenge.jar
 * Run with: java -jar challenge.jar
 */
import kotlin.io.*

const val trueSignature = "c0d1c3segr3t0_4bbast4n5a_lung0" // firma corretta

fun checkSignature(signature: String): Boolean {    // funzione che controlla la firma
    if(signature.length != trueSignature.length) {  // se la lunghezza è diversa, ritorna falso
        return false
    }
    for(i in 0 until signature.length) {            // altrimenti controlla carattere per carattere
        if(signature[i] != trueSignature[i]) {      // se un carattere è diverso, ritorna falso
            return false
        }
    }
    return true; // se non è stato ritornato falso, ritorna vero
}

fun main(){
    print("Enter the secret code: ")        // chiede la firma
    val signature: String = readLine()!!    // legge la firma
    if(checkSignature(signature)) {         // controlla la firma
        println("Congrats! You have found the secret code!")    // se è corretta, stampa il messaggio
    } else {
        println("Sorry, the secret code is wrong!")             // altrimenti stampa il messaggio
    }
}
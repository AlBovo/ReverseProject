/**
 * @file challenge.kt
 * @author Alan Davide Bovo (alandavide.bovo.stud@ispascalcomandini.it)
 * @date 2024-01-03
 * Compile with: kotlinc challenge.kt -include-runtime -d challenge.jar
 * Run with: java -jar challenge.jar
 */
import kotlin.io.*

const val key: String = "*7^tVr4FZ#7S4RFNd2"
const val encrypted: String = "xR\u0008G\$G\u0007\u0019kPhgCa5~\t\u0001"

fun checkSignature2(signature: String): Boolean {
    if(signature.length != key.length) { // se la lunghezza della firma è diversa dalla lunghezza della chiave
        return false
    }
    for(i in 0 until signature.length) { // per ogni carattere della firma
        // se il carattere della firma xor il carattere della chiave non è uguale al carattere cifrato
        if((signature[i].code xor key[i].code).toChar() != encrypted[i]) {
            return false
        }
    }
    return true
}

fun main(){
    print("Enter the secret code: ")        // chiede la firma
    val signature: String = readLine()!!    // legge la firma
    if(checkSignature2(signature)) {        // controlla la firma
        println("Congrats! You have found the secret code!")    // se è corretta, stampa il messaggio
    } else {
        println("Sorry, the secret code is wrong!")             // altrimenti stampa il messaggio
    }
}
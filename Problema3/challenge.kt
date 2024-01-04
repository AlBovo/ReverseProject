/**
 * @file challenge.kt
 * @author Alan Davide Bovo (alandavide.bovo.stud@ispascalcomandini.it)
 * @date 2024-01-04
 * Compile with: kotlinc challenge.kt -include-runtime -d challenge.jar
 * Run with: java -jar challenge.jar
 */
import kotlin.io.*

// la firma vera: 4v3v1_v0gl14 [di reversare ...] (l'ho accorciata per comodita')
fun checkSignature(signature: String): Boolean {    // funzione che controlla la firma
    if(signature.length != 12)    // la firma vera e' lunga 12 caratteri
        return false;

    if(signature[0].code * signature[0].code - 242 * signature[0].code != -9880)
        return false;
    if(signature[1].code * signature[1].code + 3 * signature[1].code != 14278)
        return false;
    if(signature[2].code * signature[2].code - 54 * signature[2].code != -153)
        return false;
    if(signature[3].code * signature[3].code - 61 * signature[3].code != 6726)
        return false;
    if(signature[4].code * signature[4].code - 2 * signature[4].code != 2303)
        return false;
    if(signature[5].code * signature[5].code + 101 * signature[5].code != 18620)
        return false;
    if(signature[6].code * signature[6].code + 90 * signature[6].code != 24544)
        return false;
    if(signature[7].code * signature[7].code - 72 * signature[7].code != -1152)
        return false;
    if(signature[8].code * signature[8].code + 25 * signature[8].code != 13184)
        return false;
    if(signature[9].code * signature[9].code - 260 * signature[9].code != -16416)
        return false;
    if(signature[10].code * signature[10].code - 526 * signature[10].code != -23373)
        return false;
    if(signature[11].code * signature[11].code + 425 * signature[11].code != 24804)
        return false;
    return true;    // se non e' stato trovato nessun errore, la firma e' corretta
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
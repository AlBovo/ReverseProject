/**
 * @file challenge.kt
 * @author Alan Davide Bovo (alandavide.bovo.stud@ispascalcomandini.it)
 * @date 2024-01-05
 * Compile with: kotlinc challenge.kt -include-runtime -d challenge.jar
 * Run with: java -jar challenge.jar
 */
import java.util.Random

fun main(){
    println("Welcome to the guessing game!") // stampa il messaggio di benvenuto
    println("You must guess 10 numbers that I'm thinking between 0 and 99") 
    val rnd = Random()  // crea un oggetto Random
    rnd.setSeed(0)      // imposta il seme del generatore di numeri casuali
    for(i in 1..10){
        val number = rnd.nextInt(100)           // genera un numero casuale tra 0 e 99
        print("Can you guess the $i number? ")  // stampa il messaggio di richiesta
        var guess = readLine()!!.toInt()        // legge il numero inserito dall'utente
        if(guess != number)                     // se il numero inserito non è corretto
            break
        if(i == 10)                             // se è l'ultimo numero
            println("Congratulations! You won the game!")
    }
    println("You lost the game!")               // stampa il messaggio di sconfitta
}
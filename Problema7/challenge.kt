/**
 * @file challenge.kt
 * @author Antonio De Rosa (antonio.derosa.stud@ispascalcomandini.it)
 * @date 2024-01-18
 * Compile with: kotlinc challenge.kt -include-runtime -d challenge.jar
 * Run with: java -jar challenge.jar
 */

import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

fun main(args: Array<String>) {
    // Non abbiamo più un sito disponibile per questo compito (non voglio scrivere una gh-page)
    val urlFlag = "https://github.com/AlBovo/ReverseProject/blob/main/Problema7/flag.txt"
    val url = URL(urlFlag)
    val connection: HttpURLConnection = url.openConnection() as HttpURLConnection
    connection.requestMethod = "GET"

    println("Vuoi leggere la flag? Inserisci l'url da cui prendere la flag\nSicuro di riuscirci?")
    val input = readln()
    if (input == urlFlag) {
        val status = connection.getResponseCode()
        val `in` = BufferedReader(
            InputStreamReader(connection.inputStream)
        )
        var inputLine: String?
        val content = StringBuffer()
        while (`in`.readLine().also { inputLine = it } != null) {
            content.append(inputLine)
        }
        `in`.close()
        connection.disconnect()

        println(content)
    } else {
        println("Non sei riuscito a ricevere la flag! (Prova a sbirciare il codice)")
    }
}
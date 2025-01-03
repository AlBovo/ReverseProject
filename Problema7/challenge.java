/**
 * @file challenge.java
 * @author Antonio De Rosa (antonio.derosa.stud@ispascalcomandini.it)
 * @date 2024-01-18
 */
package Problema7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class challenge {
    public static void main(String[] args) throws IOException {
        // Non abbiamo più un sito disponibile per questo compito (non voglio scrivere una gh-page)
        String urlFlag = "https://github.com/AlBovo/ReverseProject/blob/main/Problema7/flag.txt";
        URL url = new URL(urlFlag);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        if(readLine("Vuoi leggere la flag? Inserisci l'url da cui prendere la flag\nSicuro di riuscirci?").equalsIgnoreCase(urlFlag)) {
            int status = connection.getResponseCode();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            connection.disconnect();

            System.out.println(content);
        } else {
            System.out.println("Non sei riuscito a ricevere la flag! (Prova a sbirciare il codice)");
        }
    }

    public static String readLine(String message) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println(message);
            String inputLine = reader.readLine();

            return inputLine;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return message;
    }
}
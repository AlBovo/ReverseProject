/**
 * @file main.cs
 * @author Antonio De Rosa (antonio.derosa.stud@ispascalcomandini.it)
 * @date 2024-01-18
 * Compile with: mcs -out:main.exe main.cs
 */

using System;
using System.IO;
using System.Net;

public class MainClass {
    static void Main(string[] args)
    {
        // Non abbiamo più un sito disponibile per questo compito (non voglio scrivere una gh-page)
        string urlFlag = "https://github.com/AlBovo/ReverseProject/blob/main/Problema7/flag.txt";
        Console.WriteLine("Vuoi leggere la flag? Inserisci l'url da cui prendere la flag\nSicuro di riuscirci?");
        string inputUrl = Console.ReadLine();

        if (inputUrl == urlFlag)
        {
            try
            {
                HttpWebRequest request = (HttpWebRequest) WebRequest.Create(urlFlag);
                request.Method = "GET";

                using (HttpWebResponse response = (HttpWebResponse)request.GetResponse())
                using (Stream stream = response.GetResponseStream())
                using (StreamReader reader = new StreamReader(stream))
                {
                    string content = reader.ReadToEnd();
                    Console.WriteLine(content);
                }
            }
            catch (WebException e)
            {
                Console.WriteLine($"Errore durante la richiesta: {e.Message}");
            }
        }
        else
        {
            Console.WriteLine("Non sei riuscito a ricevere la flag! (Prova a sbirciare il codice)");
        }
    }
}
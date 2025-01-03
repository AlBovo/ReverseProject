/**
 * @file main.cpp
 * @author Antonio De Rosa (antonio.derosa.stud@ispascalcomandini.it)
 * @date 2024-01-18
 * Compile with: g++ main.cpp -o main
 */

#include <iostream>
#include <fstream>
#include <curl/curl.h>

size_t WriteCallback(void* contents, size_t size, size_t nmemb, std::string* output)
{
    size_t total_size = size * nmemb;
    output->append(static_cast<char*>(contents), total_size);
    return total_size;
}

bool makeHttpRequest(const std::string& url, std::string& content)
{
    CURL* curl;
    CURLcode res;

    curl_global_init(CURL_GLOBAL_DEFAULT);
    curl = curl_easy_init();

    if (curl)
    {
        curl_easy_setopt(curl, CURLOPT_URL, url.c_str());
        curl_easy_setopt(curl, CURLOPT_WRITEFUNCTION, WriteCallback);
        curl_easy_setopt(curl, CURLOPT_WRITEDATA, &content);

        res = curl_easy_perform(curl);

        if (res != CURLE_OK)
        {
            std::cerr << "Errore durante la richiesta: " << curl_easy_strerror(res) << std::endl;
            return false;
        }

        curl_easy_cleanup(curl);
    }
    else
    {
        std::cerr << "Impossibile inizializzare cURL." << std::endl;
        return false;
    }

    curl_global_cleanup();
    return true;
}

int main()
{
    // Non abbiamo più un sito disponibile per questo compito (non voglio scrivere una gh-page)
    std::string urlFlag = "https://github.com/AlBovo/ReverseProject/blob/main/Problema7/flag.txt";
    std::cout << "Vuoi leggere la flag? Inserisci l'url da cui prendere la flag\nSicuro di riuscirci?" << std::endl;
    
    std::string inputUrl;
    std::getline(std::cin, inputUrl);

    if (inputUrl == urlFlag)
    {
        std::string content;
        if (makeHttpRequest(urlFlag, content))
        {
            std::cout << content << std::endl;
        }
    }
    else
    {
        std::cout << "Non sei riuscito a ricevere la flag! (Prova a sbirciare il codice)" << std::endl;
    }

    return 0;
}

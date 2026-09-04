package com.salsapicara.demo.service;


import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


public class TelegramService {

    private final HttpClient client = HttpClient.newHttpClient();

private final String token = System.getenv("TELEGRAM_BOT_TOKEN");
private final String chatId1 = System.getenv("TELEGRAM_CHAT_ID");
   private final String chatId2 = System.getenv("TELEGRAM_CHAT_ID2");

    public void enviarMensaje(String mensaje) {

        try {

            String texto = URLEncoder.encode(
                    mensaje,
                    StandardCharsets.UTF_8
            );

            String url = "https://api.telegram.org/bot"
                                                       + token
                                                              + "/sendMessage?chat_id="
                                                                                          + chatId1
                                                                                                     + "&text="
                                                                                                                + texto;

              String url2= "https://api.telegram.org/bot"
                                                       + token
                                                              + "/sendMessage?chat_id="
                                                                                          + chatId2
                                                                                                     + "&text="
                                                                                                                + texto;

         
         
                     HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();
             HttpRequest request2 = HttpRequest.newBuilder()
                    .uri(URI.create(url2))
                    .GET()
                    .build();

      
                    HttpResponse<String> response =
                    client.send(
                            request,
                            HttpResponse.BodyHandlers.ofString());
        
             HttpResponse<String> response2 =
                    client.send(
                            request2,
                            HttpResponse.BodyHandlers.ofString());   

                        } catch (Exception e) {
            e.printStackTrace();
        }
     
}


}











package com.alura.util;

import com.alura.model.Converter;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class RequestMaker {

    public static String doARequest(String code){
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().
                uri(URI.create("https://v6.exchangerate-api.com/v6/660c900078ee86b2279263c7/latest/"+code)).
                GET().
                build();
        try {
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static Converter requestAConverter(String code){
        Gson gson = new Gson();

        JsonObject jsonObject = gson.fromJson(doARequest(code), JsonObject.class);

        JsonElement conversion_rates = jsonObject.get("conversion_rates");

        return gson.fromJson(conversion_rates, Converter.class);
    }
}

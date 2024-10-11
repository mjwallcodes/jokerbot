package com.michaelscode.bot;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;
import java.io.IOException;

public class JokeApi {
    private String url = "https://icanhazdadjoke.com/";

    public String getJoke() {
        OkHttpClient client = new OkHttpClient();

        // Create a request to the joke API with the correct headers
        Request request = new Request.Builder()
                .url(url)
                .header("Accept", "application/json") // Request JSON response
                .build();

        Response response = null;
        try {
            // Execute the request
            response = client.newCall(request).execute();

            // Ensure we got a successful response
            if (!response.isSuccessful()) {
                return "Failed to get a joke, try again later!";
            }

            // Parse the response body
            String responseBody = response.body().string();
            JSONObject jsonResponse = new JSONObject(responseBody);

            // Extract the joke from the JSON object
            return jsonResponse.getString("joke");

        } catch (IOException e) {
            e.printStackTrace();
            return "An error occurred while fetching a joke!";
        } finally {
            // Close the response to avoid resource leaks
            if (response != null) {
                response.close();
            }
        }
    }
}
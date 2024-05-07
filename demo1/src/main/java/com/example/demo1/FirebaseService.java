package com.example.demo1;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class FirebaseService {

    private static final String API_KEY = "AIzaSyAry73umMs1OzJHpB0A5zStFolI_WW-F3M";

    public void signInWithEmailAndPassword(String email, String password) {
        try {
            String requestBody = String.format("{\"email\": \"%s\", \"password\": \"%s\", \"returnSecureToken\": true}", email, password);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=" + API_KEY))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();

            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                // Handle successful authentication
                System.out.println("Authentication successful");
                // You can parse the response body to get the token and user details
                System.out.println(response.body());
            } else {
                // Handle error
                System.out.println("Authentication failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Handle exceptions, such as network errors
        }
    }
}
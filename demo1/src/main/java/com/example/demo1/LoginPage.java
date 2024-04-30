package com.example.demo1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.json.JSONObject;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Controller class for the login page.
 */
public class LoginPage {

    @FXML
    private TextField login;

    @FXML
    private TextField password;

    @FXML
    private Button loginButton;
    @FXML
    private Button signButton;

    /**
     * Validates the login and password fields and redirects to the main screen if both are non-empty.
     * Shows an error message if any field is empty.
     */
    @FXML
    private void setLoginButton() {
        if (login.getText().isEmpty() || password.getText().isEmpty()) {
            showAlert("Error", "Error in login/password. Please try again.");
            // Attempt to sign in with the provided email and password.
        } else {
            signInWithEmailAndPassword(login.getText(), password.getText());
        }
    }

    // Attempts to authenticate the user with Firebase using email and password.
    private void signInWithEmailAndPassword(String email, String password) {
        String apiKey = "AIzaSyAry73umMs1OzJHpB0A5zStFolI_WW-F3M";
        // Prepare the request body with email, password, and returnSecureToken flag.
        String requestBody = String.format("{\"email\":\"%s\", \"password\":\"%s\", \"returnSecureToken\":true}", email, password);

        // Create the HTTP request for Firebase authentication.
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=" + apiKey))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        // Send the request asynchronously and handle the response or errors.
        HttpClient client = HttpClient.newHttpClient();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(responseBody -> {
                    javafx.application.Platform.runLater(() -> {
                        try {
                            // Parse the response and navigate to the main screen if authentication is successful.
                            JSONObject response = new JSONObject(responseBody);
                            if (response.has("idToken")) {
                                // User successfully authenticated
                                loadMainScreen();
                            } else if (response.has("error")) {
                                // Parsing the error message received from Firebase
                                JSONObject error = response.getJSONObject("error");
                                String errorMessage = error.getJSONArray("errors").getJSONObject(0).getString("message");
                                if ("Invalid Email".equals(errorMessage) || "Invalid Password".equals(errorMessage) || "USER_DISABLED".equals(errorMessage)) {
                                    showAlert("Login Failed", "No account found with the provided credentials or the account has been disabled.");
                                } else {
                                    showAlert("Login Failed", "An error occurred while trying to log in: " + errorMessage);
                                }
                            }
                        } catch (Exception e) {
                            showAlert("Error", "An error occurred while processing the login response.");
                            e.printStackTrace();
                        }
                    });
                })
                // Handle communication errors with Firebase.
                .exceptionally(e -> {
                    javafx.application.Platform.runLater(() -> showAlert("Login Failed", "Failed to communicate with Firebase."));
                    e.printStackTrace();
                    return null;
                });
    }


    private void loadMainScreen() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("newMainScreen.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) loginButton.getScene().getWindow();
            stage.setScene(new Scene(root, 1200, 750));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "Failed to load the main screen. Please try again later.");
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }




    @FXML
    private void setSignUpPage() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("signuppage.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) signButton.getScene().getWindow();
            Scene scene = new Scene(root, 1200, 750);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle exception
        }
    }
}

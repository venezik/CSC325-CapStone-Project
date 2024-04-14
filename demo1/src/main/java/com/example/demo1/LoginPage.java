package com.example.demo1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

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
        // Check if the login and password fields are empty
        if (login.getText().isEmpty() || password.getText().isEmpty()) {
            // Show an error message if any of the fields are empty
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Error in login/password. Please try again.");
            alert.showAndWait();
        } else {
            try {
                // Load the FXML file for the new main screen
                FXMLLoader loader = new FXMLLoader(getClass().getResource("newMainScreen.fxml"));
                Parent root = loader.load();

                // Get the current stage
                Stage stage = (Stage) loginButton.getScene().getWindow();

                // Set the scene of the current stage to the new main screen scene
                Scene scene = new Scene(root, 1200,750);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
                // Handle the exception (e.g., show an error message)
            }
        }
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

package com.example.demo1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class SignUp {
    @FXML
    private Button logInPage;

    @FXML
    private Button signButton;


    @FXML
    private void setLogInPage() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("loginPage.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) logInPage.getScene().getWindow();
            Scene scene = new Scene(root, 1200, 750);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle exception
        }
    }

    @FXML
    private void setSignUpButton() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("CONFIRMATION");
        alert.setHeaderText(null);
        alert.setContentText("Sign up Successful!");
        alert.showAndWait();

            try {
                // Load the FXML file for the new main screen
                FXMLLoader loader = new FXMLLoader(getClass().getResource("newMainScreen.fxml"));
                Parent root = loader.load();

                // Get the current stage
                Stage stage = (Stage) signButton.getScene().getWindow();

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

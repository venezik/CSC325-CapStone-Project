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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;


public class SignUp {
    @FXML
    private Button logInPage;

    @FXML
    private Button signButton;

    @FXML
    private TextField password;

    @FXML
    private TextField password1;

    @FXML
    private TextField userNameTf;


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

        String email = password.getText();
        String password = password1.getText();

        // Regular expressions for email and password restrictions
        String emailIsValid = "[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}";

        String passwordIsValid = "^.{6,}$"; // Password should be exactly 6 characters long

        // Check if email and password meet the required format
        if (!email.matches(emailIsValid)) {
            showAlert("Invalid Email", "\n Email must follow string1@string2.domain format");
            return;
        }

        if (!password.matches(passwordIsValid)) {
            showAlert("Invalid Password", "Password should be 6 characters long.");
            return;
        }

        try {
            // Create a user with the given email and password
            UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                    .setEmail(email)
                    .setPassword(password);
            UserRecord userRecord = FirebaseAuth.getInstance().createUser(request);

            // User created successfully
            showAlert("Sign Up Successful", "User created with UID: " + userRecord.getUid());

            // Navigate to the new main screen
            FXMLLoader loader = new FXMLLoader(getClass().getResource("newMainScreen.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) signButton.getScene().getWindow();
            Scene scene = new Scene(root, 1200, 750);
            stage.setScene(scene);
            stage.show();
        } catch (FirebaseAuthException | IOException e) {
            // Error creating user or navigating to the new main screen
            showAlert("Sign Up Failed", "Error: " + e.getMessage());
        }
    }


    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}

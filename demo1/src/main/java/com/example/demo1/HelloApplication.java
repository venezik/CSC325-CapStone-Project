package com.example.demo1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;

import com.google.auth.Credentials;


import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;



public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Initialize Firebase
        try {
            // Load the service account JSON file
            FileInputStream serviceAccount = new FileInputStream("demo1/src/main/resources/firebase/fscshop-firebase-firebase-adminsdk-pkafo-7a5b9983a5.json");

            // Initialize Firebase Admin SDK
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            FirebaseApp.initializeApp(options);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Load the FXML file
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 750);

        // Set the stage title and scene
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
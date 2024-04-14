package com.example.demo1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller class for handling pop-up panes.
 */
public class PopUpPanes {
    @FXML
    private Button logOut;


    @FXML
    private Button closeButton;
    @FXML
    private Label priceBT;




    /**
     * Closes the iPhone pop-up pane.
     */
    @FXML
    private void closeIphonePopup() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void addIphonecart() {
        if (priceBT != null) {
            try {
                double currentValue = Double.parseDouble(priceBT.getText());
                double newValue = currentValue + 799.95;
                priceBT.setText(String.format("%.2f", newValue));
            } catch (NumberFormatException e) {
                System.err.println("Error: Could not parse text to double");
                e.printStackTrace();
            }
        } else {
            System.err.println("Error: priceBT is null");
        }
    }

    @FXML
    private HBox hboxToDelete;

    @FXML
    private void deleteButton() {
        // Remove the HBox from its parent
        hboxToDelete.getParent().getChildrenUnmodifiable().remove(hboxToDelete);
    }


    @FXML
    private void logOutButton() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("CONFIRMATION");
        alert.setHeaderText(null);
        alert.setContentText("Log Out Successful!");
        alert.showAndWait();

        try {
            // Load the FXML file for the new main screen
            FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
            Parent root = loader.load();

            // Get the current stage
            Stage stage = (Stage) logOut.getScene().getWindow();

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

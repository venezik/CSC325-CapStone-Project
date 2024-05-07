package com.example.demo1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

/**
 * Controller class for the main application view.
 */
public class HelloController {

    @FXML
    private BorderPane borderPane;


    @FXML
    private CheckBox checkBox1;
    @FXML
    private CheckBox checkBox2;
    @FXML
    private CheckBox checkBox3;
    @FXML
    private CheckBox checkBox4;
    @FXML
    private CheckBox checkBox5;
    @FXML
    private CheckBox checkBox6;
    @FXML
    private CheckBox checkBox7;
    @FXML
    private CheckBox checkBox8;
    @FXML
    private CheckBox checkBox9;
    @FXML
    private CheckBox checkBox10;
    @FXML
    private CheckBox checkBox11;
    @FXML
    private CheckBox checkBox12;

    @FXML
    private Button logInPage;
    @FXML
    private Button logOut;

    @FXML
    private Button cart;



    /**
     * Switches to the login page.
     */
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
    private void setSignUpPage() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("signuppage.fxml"));
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

    /**
     * Handles the selection/deselection of price filter 1.
     */
    @FXML
    private void priceFilter1() {
        if (checkBox1.isSelected()) {
            filter1open();
        } else {
            filter1switch();
        }
    }

    /**
     * Handles the selection/deselection of price filter 2.
     */
    @FXML
    private void priceFilter2() {
        if (checkBox2.isSelected()) {
            filter2open();
        } else {
            filter1switch();
        }
    }

    /**
     * Handles the selection/deselection of price filter 3.
     */
    @FXML
    private void priceFilter3() {
        if (checkBox3.isSelected()) {
            filter3open();
        } else {
            filter1switch();
        }
    }

    /**
     * Opens filter 1.
     */
    public void filter1open() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("filter1.fxml"));
            Pane centerPane = loader.load();
            borderPane.setCenter(centerPane);
        } catch (IOException e) {
            e.printStackTrace();
            // Handle exception
        }
    }

    /**
     * Opens filter 2.
     */
    public void filter2open() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("filter2.fxml"));
            Pane centerPane = loader.load();
            borderPane.setCenter(centerPane);
        } catch (IOException e) {
            e.printStackTrace();
            // Handle exception
        }
    }

    /**
     * Opens filter 3.
     */
    public void filter3open() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("filter3.fxml"));
            Pane centerPane = loader.load();
            borderPane.setCenter(centerPane);
        } catch (IOException e) {
            e.printStackTrace();
            // Handle exception
        }
    }

    /**
     * Switches to the main page.
     */
    public void filter1switch() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("mainpage.fxml"));
            Pane centerPane = loader.load();
            borderPane.setCenter(centerPane);
        } catch (IOException e) {
            e.printStackTrace();
            // Handle exception
        }
    }

    /**
     * Opens a pop-up window.
     *
     * @param fxmlFile The FXML file to load.
     */
    private void openPopUp(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage popupStage = new Stage();
            popupStage.initStyle(StageStyle.UNDECORATED);
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.setScene(scene);
            Pane overlayPane = new Pane();
            overlayPane.setStyle("-fx-background-color: rgba(0, 0, 0, 0.5)");
            overlayPane.setPrefSize(popupStage.getWidth(), popupStage.getHeight());
            root.setOnMouseClicked(event -> event.consume());
            ((Pane) root).getChildren().add(overlayPane);
            popupStage.show();
            popupStage.toFront();
            Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
            double centerX = screenBounds.getMinX() + (screenBounds.getWidth() - popupStage.getWidth()) / 2;
            double centerY = screenBounds.getMinY() + (screenBounds.getHeight() - popupStage.getHeight()) / 2;
            popupStage.setX(centerX);
            popupStage.setY(centerY);
        } catch (IOException e) {
            e.printStackTrace();
            // Handle exception
        }
    }

    // Methods to open various pop-ups
    @FXML
    private void openIphonePopup() {
        openPopUp("iphonepopup.fxml");
    }

    @FXML
    private void openPsPopup() {
        openPopUp("ps5popup.fxml");
    }

    @FXML
    private void openSonyHeadphonePopUp() {
        openPopUp("sonyHeadphones.fxml");
    }

    @FXML
    private void openXboxXPopUp() {
        openPopUp("xboxx.fxml");
    }

    @FXML
    private void openSurfacePopup() {
        openPopUp("surfaclaptop.fxml");
    }

    @FXML
    private void openPixelPopUp() {
        openPopUp("googlepixel.fxml");
    }

    @FXML
    private void openBudsPopUp() {
        openPopUp("googlebuds.fxml");
    }

    @FXML
    private void openAirpodsPopUp() {
        openPopUp("airpods.fxml");
    }

    @FXML
    private void openPixelbookPopUp() {
        openPopUp("pixelbook.fxml");
    }

    @FXML
    private void openMacbookPopUp() {
        openPopUp("macbook.fxml");
    }

    @FXML
    private void openXperiaPopUp() {
        openPopUp("xperia.fxml");
    }

    @FXML
    private void openXboxSPopUp() {
        openPopUp("xboxs.fxml");
    }
    @FXML
    private void openCart() {
        try {
            // Load the FXML file for the new main screen
            FXMLLoader loader = new FXMLLoader(getClass().getResource("cart.fxml"));
            Parent root = loader.load();

            // Get the current stage
            Stage stage = (Stage) cart.getScene().getWindow();

            // Set the scene of the current stage to the new main screen scene
            Scene scene = new Scene(root, 1200,909);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception (e.g., show an error message)
        }
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

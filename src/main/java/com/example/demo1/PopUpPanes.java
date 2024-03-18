package com.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Controller class for handling pop-up panes.
 */
public class PopUpPanes {

    @FXML
    private Button closeButton;

    /**
     * Closes the iPhone pop-up pane.
     */
    @FXML
    private void closeIphonePopup() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}

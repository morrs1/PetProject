package org.example.petproject;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainWindowController {
    @FXML
    private Label welcomeText;
    @FXML
    private Label testLabel;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML protected void onTestCheckBoxClick() {
        testLabel.setText("Ты лох");
    }
}
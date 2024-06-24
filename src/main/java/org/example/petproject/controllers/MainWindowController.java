package org.example.petproject.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.example.petproject.core.SceneController;
import org.example.petproject.core.enums.Scenes;

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
    @FXML protected void onGoToLabButtonClick() {
        SceneController.getInstance().setScene(Scenes.LABORATORY_WINDOW);
    }
    @FXML protected void onGoToTestButtonClick() {
        SceneController.getInstance().setScene(Scenes.TEST_WINDOW);
    }
}
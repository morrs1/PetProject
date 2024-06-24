package org.example.petproject.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.example.petproject.core.SceneController;
import org.example.petproject.core.enums.Scenes;

public class LaboratoryWindowController {
    @FXML
    private Button backToMenuButton;

    @FXML
    protected void onBackToMenuButtonClick(){
        SceneController.getInstance().setPreviousScene();
    }

    @FXML
    protected void onGoToTestButtonClick(){
        SceneController.getInstance().setScene(Scenes.TEST_WINDOW);
    }

}

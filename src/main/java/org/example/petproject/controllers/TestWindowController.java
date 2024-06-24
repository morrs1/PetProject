package org.example.petproject.controllers;

import javafx.fxml.FXML;
import org.example.petproject.core.SceneController;
import org.example.petproject.core.enums.Scenes;

public class TestWindowController {
    @FXML
    protected void onBackButtonClick(){
        SceneController.getInstance().setPreviousScene();
    }
}

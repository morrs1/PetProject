package org.example.petproject.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;

/**
 * Абстрактный класс для обобщения классов сцен
 */
public abstract class BaseController {
    @FXML
    protected void onCloseButtonClick() {
        Platform.exit();
    }
    @FXML
    protected void onBackToMenuButtonClick(){
        SceneController.getInstance().setPreviousScene();
    }
}

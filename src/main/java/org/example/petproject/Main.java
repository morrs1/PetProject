package org.example.petproject;

import javafx.application.Application;
import javafx.stage.Stage;
import org.example.petproject.controllers.SceneController;
import org.example.petproject.core.classes.StageConfigurator;
import org.example.petproject.core.enums.Scenes;

/**
 * Точка запуска проекта, в которой конфигурируется stage и sceneController
 */
public class Main extends Application {
    @Override
    public void start(Stage stage){
        Stage initializeStage = StageConfigurator.configureStage(stage);
        SceneController sceneController = SceneController.getInstance(stage);
        sceneController.setScene(Scenes.MAIN_WINDOW);
        initializeStage.show();
    }
}
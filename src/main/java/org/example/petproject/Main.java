package org.example.petproject;

import javafx.application.Application;
import javafx.stage.Stage;
import org.example.petproject.core.SceneController;
import org.example.petproject.core.enums.Scenes;

public class Main extends Application {
    @Override
    public void start(Stage stage){
        stage.setTitle("Hello!");
        SceneController sceneController = new SceneController(stage);
        sceneController.setScene(Scenes.MAIN_WINDOW);
        stage.show();
    }
}
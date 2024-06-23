package org.example.petproject.core;

import javafx.stage.Stage;
import lombok.Getter;
import org.example.petproject.core.classes.SceneLoader;
import org.example.petproject.core.enums.Scenes;


public class SceneController {
    @Getter
    private static SceneController instance;
     Stage stage;

    public static SceneController getInstance(Stage stage) {
        if (instance == null) {
            instance = new SceneController();
            instance.stage = stage;
        }
        return instance;
    }


    public void setScene(Scenes scene) {
        instance.stage.setScene(SceneLoader.getInstance().getScenes().get(scene.getName()));
    }


    private SceneController(){

    }
}

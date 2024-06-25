package org.example.petproject.controllers;

import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.Getter;
import org.example.petproject.core.classes.SceneLoader;
import org.example.petproject.core.enums.Scenes;

import java.util.Stack;

/**
 * Класс для управления сценами(какая сцена будет отображаться на Stage)
 */
public class SceneController {
    @Getter
    private static SceneController instance;
    Stage stage;
    private final Stack<Scene> stackOfScenes = new Stack<>();

    public static SceneController getInstance(Stage stage) {
        if (instance == null) {
            instance = new SceneController();
            instance.stage = stage;
        }
        return instance;
    }


    public void setScene(Scenes scene) {
        stackOfScenes.push(instance.stage.getScene());
        instance.stage.setScene(SceneLoader.getInstance().getScenes().get(scene.getName()));
    }

    public void setPreviousScene() {
        if (!stackOfScenes.isEmpty()) instance.stage.setScene(stackOfScenes.pop());
    }


    private SceneController() {

    }
}

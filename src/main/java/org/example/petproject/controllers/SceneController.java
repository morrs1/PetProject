package org.example.petproject.controllers;

import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SceneController {
    Stage stage;

    public void setScene(Scene scene) {
        stage.setScene(scene);
    }
}

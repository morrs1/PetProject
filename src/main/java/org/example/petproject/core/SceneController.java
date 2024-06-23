package org.example.petproject.core;

import javafx.stage.Stage;
import lombok.RequiredArgsConstructor;
import org.example.petproject.core.classes.SceneLoader;
import org.example.petproject.core.enums.Scenes;

@RequiredArgsConstructor
public class SceneController {
    final Stage stage;

    public void setScene(Scenes scene) {
        stage.setScene(SceneLoader.getInstance().getScenes().get(scene.getName()));
    }
}

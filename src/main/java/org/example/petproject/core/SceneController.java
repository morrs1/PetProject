package org.example.petproject.core;

import javafx.stage.Stage;
import lombok.AllArgsConstructor;
import org.example.petproject.core.classes.SceneLoader;
import org.example.petproject.core.enums.Scenes;

@AllArgsConstructor
public class SceneController {
    Stage stage;

    public void setScene(Scenes scene) {
        switch (scene) {
            case Scenes.LABORATORY_WINDOW -> stage.setScene(SceneLoader.laboratoryScene);
            case Scenes.MAIN_WINDOW -> stage.setScene(SceneLoader.mainScene);
        }
    }
}

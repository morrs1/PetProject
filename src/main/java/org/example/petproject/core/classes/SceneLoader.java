package org.example.petproject.core.classes;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.Getter;
import org.example.petproject.Main;
import org.example.petproject.core.enums.Scenes;

import java.io.IOException;


public class SceneLoader {
    public static final Scene mainScene;
    public static final Scene laboratoryScene;

    static {
        try {
            mainScene = new Scene(new FXMLLoader(Main.class.getResource("mainWindow.fxml")).load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static {
        try {
            laboratoryScene = new Scene(new FXMLLoader(Main.class.getResource("laboratoryWindow.fxml")).load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}

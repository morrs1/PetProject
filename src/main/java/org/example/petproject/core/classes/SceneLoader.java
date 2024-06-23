package org.example.petproject.core.classes;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import lombok.Getter;
import org.example.petproject.Main;
import org.example.petproject.core.json.ParserScenesJson;
import org.example.petproject.core.json.ScenesJson;

import java.io.IOException;
import java.util.HashMap;


@Getter
public class SceneLoader {
    private static SceneLoader instance;
    private  HashMap<String, Scene> scenes;

    public static SceneLoader getInstance() {
        if (instance == null) {
            instance = new SceneLoader();
            ScenesJson scenesJson = ParserScenesJson.parseScenesJson("src/main/resources/org/example/petproject/Scenes.json");
            instance.scenes = new HashMap<>();
            scenesJson.pathToScenes().forEach((key, value) -> {
                try {
                    instance.scenes.put(key, new Scene(new FXMLLoader(Main.class.getResource(value)).load()));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        return instance;
    }

    private SceneLoader(){

    }

}

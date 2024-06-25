package org.example.petproject.core.classes;

import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class StageConfigurator {

    public static Stage configureStage(Stage primaryStage) {
        primaryStage.setTitle("Hello!");
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.TRANSPARENT);

        return primaryStage;
    }
}

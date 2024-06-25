package org.example.petproject.core.classes;

import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Класс для конфигурации изначального Stage
 */
public class StageConfigurator {

    public static void configureStage(Stage primaryStage) {
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setWidth(600);
        primaryStage.setHeight(400);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }
}

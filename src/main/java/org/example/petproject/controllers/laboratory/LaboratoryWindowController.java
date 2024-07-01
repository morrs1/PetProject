package org.example.petproject.controllers.laboratory;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import org.example.petproject.controllers.BaseController;
import org.example.petproject.controllers.SceneController;
import org.example.petproject.core.enums.Scenes;

import java.awt.*;

/**
 * Класс, для управления сценой с лабой
 */
public class LaboratoryWindowController extends BaseController {
    @FXML
    protected void onTaskButtonClick(MouseEvent event){
        Button pressedButton = (Button) event.getSource();
        String numberOfTask = pressedButton.getText();

        Scenes sceneToSwitch = switch (numberOfTask){
            case "1"-> Scenes.FIRST_TASK_WINDOW;
            case "2"-> Scenes.SECOND_TASK_WINDOW;
            case "3"-> Scenes.THIRD_TASK_WINDOW;
            default -> throw new IllegalStateException("Unexpected value: " + numberOfTask);
        };
        SceneController.getInstance().setScene(sceneToSwitch);

    }

}

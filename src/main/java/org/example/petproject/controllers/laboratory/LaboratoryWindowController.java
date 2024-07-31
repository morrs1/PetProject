package org.example.petproject.controllers.laboratory;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import org.example.petproject.controllers.BaseController;
import org.example.petproject.controllers.SceneController;
import org.example.petproject.core.enums.Scenes;


/**
 * Класс, для управления сценой с лабой
 */
public class LaboratoryWindowController extends BaseController {
    @FXML
    protected void onTaskButtonClick(MouseEvent event) {
        Button pressedButton = (Button) event.getSource();
        String numberOfTask = pressedButton.getText();

        Scenes sceneToSwitch = switch (numberOfTask) {
            case "1" -> Scenes.FIRST_TASK_WINDOW;
            case "2" -> Scenes.SECOND_TASK_WINDOW;
            case "3" -> Scenes.THIRD_TASK_WINDOW;
            case "4" -> Scenes.FOURTH_TASK_WINDOW;
            case "5" -> Scenes.FIFTH_TASK_WINDOW;
            case "6" -> Scenes.SIXTH_TASK_WINDOW;
            case "7" -> Scenes.SEVENTH_TASK_WINDOW;
            case "8" -> Scenes.EIGHTH_TASK_WINDOW;
            default -> throw new IllegalStateException("Unexpected value: " + numberOfTask);
        };
        SceneController.getInstance().setScene(sceneToSwitch);
    }

}

package org.example.petproject.controllers.laboratory;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.example.petproject.controllers.BaseController;
import org.example.petproject.controllers.SceneController;
import org.example.petproject.core.enums.Scenes;

/**
 * Класс, для управления сценой с лабой
 */
public class LaboratoryWindowController extends BaseController {
    @FXML
    protected void onFirstButtonClick(){
        SceneController.getInstance().setScene(Scenes.FIRST_TASK_WINDOW);
    }

}

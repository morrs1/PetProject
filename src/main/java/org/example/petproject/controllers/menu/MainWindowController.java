package org.example.petproject.controllers.menu;

import javafx.fxml.FXML;
import org.example.petproject.controllers.BaseController;
import org.example.petproject.controllers.SceneController;
import org.example.petproject.core.enums.Scenes;

public class MainWindowController extends BaseController {
    @FXML
    protected void onGoToLabButtonClick() {
        SceneController.getInstance().setScene(Scenes.LABORATORY_WINDOW);
    }
}
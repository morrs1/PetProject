package org.example.petproject.controllers.laboratory.tasksForLaboratoryControllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import org.example.petproject.controllers.BaseController;
import org.example.petproject.core.classes.SceneLoader;

import java.net.URL;
import java.util.ResourceBundle;

public class FirstTaskController extends BaseController implements Initializable {
    @FXML
    AnchorPane paneForFirstTask;
    @FXML
    ToggleGroup firstTaskToggleButtonsGroup;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        paneForFirstTask.setOnMouseClicked(mouseEvent -> {
            if (firstTaskToggleButtonsGroup.getSelectedToggle() != null) {
                ImageView copiedImageView = ((ImageView) ((ToggleButton) firstTaskToggleButtonsGroup.getSelectedToggle()).getGraphic());
                ImageView imageForPane = new ImageView(copiedImageView.getImage());
                imageForPane.setX(mouseEvent.getX());
                imageForPane.setY(mouseEvent.getY());
                paneForFirstTask.getChildren().add(imageForPane);
            }
        });
    }


}

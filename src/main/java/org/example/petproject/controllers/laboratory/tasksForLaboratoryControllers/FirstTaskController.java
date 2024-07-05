package org.example.petproject.controllers.laboratory.tasksForLaboratoryControllers;


import javafx.fxml.FXML;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import org.example.petproject.controllers.BaseController;
import javafx.embed.swing.SwingFXUtils;
import org.example.petproject.controllers.SceneController;
import org.example.petproject.core.classes.FileSaver;

import javax.imageio.ImageIO;
import java.io.*;


public class FirstTaskController extends BaseController {
    @FXML
    AnchorPane paneForFirstTask;
    @FXML
    ToggleGroup firstTaskToggleButtonsGroup;

    @FXML
    protected void onAnchorPaneClick(MouseEvent mouseEvent) {
        if (firstTaskToggleButtonsGroup.getSelectedToggle() != null) {
            ImageView copiedImageView = ((ImageView) ((ToggleButton) firstTaskToggleButtonsGroup.getSelectedToggle()).getGraphic());
            ImageView imageForPane = new ImageView(copiedImageView.getImage());
            imageForPane.setX(mouseEvent.getX() - copiedImageView.getImage().getWidth() / 2);
            imageForPane.setY(mouseEvent.getY() - copiedImageView.getImage().getHeight() / 2);
            paneForFirstTask.getChildren().add(imageForPane);
        }
    }

    @FXML
    protected void onSaveButtonClicked() {
        FileSaver.saveFile(paneForFirstTask.snapshot(null, null), "png",
                (int) paneForFirstTask.getWidth(), (int) paneForFirstTask.getHeight());
    }


}

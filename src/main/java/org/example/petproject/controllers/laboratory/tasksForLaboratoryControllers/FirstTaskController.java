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
        WritableImage imageForSave = paneForFirstTask.snapshot(null, null);
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.png");
        fileChooser.getExtensionFilters().add(extFilter);

        File file = fileChooser.showSaveDialog(SceneController.getInstance().getStage());
        if (file != null) {
            try {
                ImageIO.write(SwingFXUtils.fromFXImage(imageForSave, null), "png", file);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }



}

package org.example.petproject.controllers.laboratory.tasksForLaboratoryControllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import org.example.petproject.controllers.BaseController;

import java.awt.*;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class SeventhTaskController extends BaseController implements Initializable {
    @FXML
    MediaView mediaViewForSeventhTask;

    private final String pathToVideo = "src/main/resources/org/example/petproject/Videos/firstVideo.mp4";

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Platform.runLater(() -> {
            File file = new File(pathToVideo);
            Media media = new Media(file.toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            mediaViewForSeventhTask.setMediaPlayer(mediaPlayer);
        });

    }

    @FXML
    protected void onPlayButtonClicked() {
        mediaViewForSeventhTask.getMediaPlayer().play();
    }
    @FXML
    protected void onStopButtonClicked(){
        mediaViewForSeventhTask.getMediaPlayer().pause();
    }
}

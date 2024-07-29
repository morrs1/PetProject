package org.example.petproject.controllers.laboratory.tasksForLaboratoryControllers;

import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import org.example.petproject.controllers.BaseController;

import java.io.File;
import java.net.URL;

import javafx.util.Duration;

import java.util.ResourceBundle;

public class SeventhTaskController extends BaseController implements Initializable {
    @FXML
    MediaView mediaViewForSeventhTask;
    @FXML
    Slider sliderForVolume;
    @FXML
    Label labelForVideoDuration;
    private final String pathToVideo = "src/main/resources/org/example/petproject/Videos/firstVideo.mp4";

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Platform.runLater(() -> {
            File file = new File(pathToVideo);
            Media media = new Media(file.toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            mediaPlayer.setVolume(0.5);
            mediaViewForSeventhTask.setMediaPlayer(mediaPlayer);
            mediaPlayer.setOnReady(() ->
                    labelForVideoDuration.setText("--:-- / " + formatDuration(media.getDuration())));
        });
        sliderForVolume.setValue(50);
        onSliderChangeValue();
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                labelForVideoDuration.setText(
                        formatDuration(mediaViewForSeventhTask.getMediaPlayer().getCurrentTime()) +
                                labelForVideoDuration.getText().substring(5)
                );
            }
        };
        timer.start();
    }

    @FXML
    protected void onPlayButtonClicked() {
        mediaViewForSeventhTask.getMediaPlayer().play();
    }

    @FXML
    protected void onStopButtonClicked() {
        mediaViewForSeventhTask.getMediaPlayer().pause();
    }

    private void onSliderChangeValue() {
        sliderForVolume.valueProperty().addListener(
                (observable, oldValue, newValue) ->
                        mediaViewForSeventhTask.getMediaPlayer().setVolume(newValue.doubleValue() / 100)
        );
    }

    private String formatDuration(Duration duration) {
        long minutes = (long) duration.toMinutes();
        long seconds = (long) duration.toSeconds() % 60; // Остаток от деления на 60 для получения секунд

        return String.format("%02d:%02d", minutes, seconds); // Форматирование в "мин:сек"
    }
}

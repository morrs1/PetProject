package org.example.petproject.controllers.laboratory.tasksForLaboratoryControllers;

import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import org.example.petproject.controllers.BaseController;

import java.io.File;
import java.net.URL;

import javafx.util.Duration;
import org.example.petproject.controllers.SceneController;

import java.util.ResourceBundle;

public class SeventhTaskController extends BaseController implements Initializable {
    @FXML
    MediaView mediaViewForSeventhTask;
    @FXML
    Slider sliderForVolume;
    @FXML
    Label labelForVideoDuration;
    @FXML
    Button chooseFileButton;
    private FileChooser fileChooser;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Video Files", "*.mp4"));
        fileChooser.setInitialDirectory(
                new File("C:\\Users\\grish\\IdeaProjects\\PetProject\\src\\main\\resources\\org\\example\\petproject\\Videos")
        );
        sliderForVolume.setValue(50);
        onSliderChangeValue();
    }

    @FXML
    protected void onPlayButtonClicked() {
        mediaViewForSeventhTask.getMediaPlayer().play();
    }

    @FXML
    protected void onStopButtonClicked() {
        mediaViewForSeventhTask.getMediaPlayer().pause();
    }

    @FXML
    protected void onChooseFileButtonClicked() {
        if (mediaViewForSeventhTask.getMediaPlayer() != null) {
            mediaViewForSeventhTask.getMediaPlayer().stop();
            mediaViewForSeventhTask.getMediaPlayer().dispose();
        }
        File videoFile = fileChooser.showOpenDialog(SceneController.getInstance().getStage());
        if (videoFile != null) {
            new Thread(() -> {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException("Косяк с прогрузкой видоса", e);
                }
                Media media = new Media(videoFile.toURI().toString());
                MediaPlayer mediaPlayer = new MediaPlayer(media);
                mediaPlayer.setVolume(0.5);
                mediaViewForSeventhTask.setMediaPlayer(mediaPlayer);
                mediaPlayer.setOnReady(() ->
                        labelForVideoDuration.setText("--:-- / " + formatDuration(media.getDuration()))
                );
                setupTimer(media);
                Platform.runLater(() -> {
                    chooseFileButton.setText(videoFile.getName());
                    sliderForVolume.setValue(50);
                });

            }).start();
        }

    }

    private void onSliderChangeValue() {
        sliderForVolume.valueProperty().addListener(
                (observable, oldValue, newValue) ->
                        mediaViewForSeventhTask.getMediaPlayer().setVolume(newValue.doubleValue() / 100)
        );
    }

    private String formatDuration(Duration duration) {
        long minutes = (long) duration.toMinutes();
        long seconds = (long) duration.toSeconds() % 60;

        return String.format("%02d:%02d", minutes, seconds);
    }

    private void setupTimer(Media media) {
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                labelForVideoDuration.setText(
                        formatDuration(mediaViewForSeventhTask.getMediaPlayer().getCurrentTime()) +
                                " / " +
                                formatDuration(media.getDuration())
                );
            }
        };
        timer.start();
    }
}

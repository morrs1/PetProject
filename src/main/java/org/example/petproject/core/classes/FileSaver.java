package org.example.petproject.core.classes;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import org.example.petproject.controllers.SceneController;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class FileSaver {
    private final static FileChooser fileChooser = new FileChooser();

    public static void setupFileChooser(String extension) {
        ExtensionFilter extFilter = new ExtensionFilter(
                String.format("PNG files (*.%s)", extension), String.format("*.%s", extension));
        fileChooser.getExtensionFilters().add(extFilter);
    }

    public static void saveFile(WritableImage image, String extension) {
        setupFileChooser(extension);
        File file = fileChooser.showSaveDialog(SceneController.getInstance().getStage());
        if (file != null) {
            try {
                ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}

package org.example.petproject.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Scenes {
    MAIN_WINDOW("mainWindow.fxml"),
    LABORATORY_WINDOW("laboratoryWindow.fxml");
    private final String path;
}

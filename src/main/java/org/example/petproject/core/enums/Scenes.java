package org.example.petproject.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Scenes {
    MAIN_WINDOW("mainWindow"),
    LABORATORY_WINDOW("laboratoryWindow"),
    TEST_WINDOW("testWindow");
    private final String name;
}

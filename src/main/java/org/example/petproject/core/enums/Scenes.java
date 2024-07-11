package org.example.petproject.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Класс для хранения имен окон, чтобы можно было легко получить доступ к ним
 */
@Getter
@AllArgsConstructor
public enum Scenes {
    MAIN_WINDOW("mainWindow"),
    LABORATORY_WINDOW("laboratoryWindow"),
    FIRST_TASK_WINDOW("firstTaskWindow"),
    SECOND_TASK_WINDOW("secondTaskWindow"),
    THIRD_TASK_WINDOW("thirdTaskWindow"),
    FOURTH_TASK_WINDOW("fourthTaskWindow");
    private final String name;
}

package org.example.petproject.core.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

/**
 * Запись, представляющая собой структуру JSON файла для парсинга
 * @param pathToScenes Словарь с путями до сцен
 */
public record ScenesJson (
        @JsonProperty("scenes")
        Map<String, String> pathToScenes
){}

package org.example.petproject.core.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * Класс для парсинга JSON файла со сценами
 */
public class ParserJson {
    public static <T> T parseScenesJson(String pathToJson, Class<T> clazz) {
        ObjectMapper objectMapper = new ObjectMapper();
        File json = new File(pathToJson);
        T jsonObject;
        try {
            jsonObject = objectMapper.readValue(json, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return jsonObject;
    }
}

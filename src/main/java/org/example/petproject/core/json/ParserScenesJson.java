package org.example.petproject.core.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * Класс для парсинга JSON файла со сценами
 */
public class ParserScenesJson {
    public static ScenesJson parseScenesJson(String pathToJson){
        ObjectMapper objectMapper = new ObjectMapper();
        File json = new File(pathToJson);
        ScenesJson scenesJson;
        try {
            scenesJson = objectMapper.readValue(json, ScenesJson.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return scenesJson;
    }
}

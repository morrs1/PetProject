package org.example.petproject.core.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

public record ScenesJson (
        @JsonProperty("scenes")
        Map<String, String> pathToScenes
){}

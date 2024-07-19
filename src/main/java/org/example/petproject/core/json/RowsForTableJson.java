package org.example.petproject.core.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public record RowsForTableJson(
        @JsonProperty("rows")
        ArrayList<ArrayList<String>> rows
) {
}

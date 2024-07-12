package org.example.petproject.model.strategyChartOfFunctions;

import javafx.scene.Node;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChartOfFunction {
    private Node currentFunction;

    public void showFunction() {
        if (currentFunction != null) {
            currentFunction.setStyle("");
        }
    }

    public void hideFunction() {
        if (currentFunction != null) {
            currentFunction.setStyle("-fx-stroke: transparent;");
        }
    }

    public void changeWidthOfFunction(String width){
        if (currentFunction != null && !width.isEmpty()) {
            currentFunction.setStyle("-fx-stroke-width: " + width + ";");
        }
    }

}

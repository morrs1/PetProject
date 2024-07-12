package org.example.petproject.model.strategyChartOfFunctions;

import javafx.scene.Node;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChartOfFunction {
    private Node currentFunction;
    private String colorOfFunction;

    public void showFunction() {
        if (currentFunction != null) {
            currentFunction.setStyle(currentFunction.getStyle() + "-fx-stroke: " + colorOfFunction + ";");
        }
    }

    public void hideFunction() {
        if (currentFunction != null) {
            currentFunction.setStyle(currentFunction.getStyle() +"-fx-stroke: transparent;");
        }
    }

    public void changeWidthOfFunction(String width){
        if (currentFunction != null && !width.isEmpty()) {
            currentFunction.setStyle(currentFunction.getStyle() + "-fx-stroke-width: " + width + ";");
        }
    }

}

package org.example.petproject.model.strategyChartOfFunctions;

import javafx.scene.Node;
import javafx.scene.chart.XYChart;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChartOfFunction {
    private Node currentFunction;

    public void showFunction() {
        if (currentFunction != null) {
            currentFunction.setStyle("");
//            for (XYChart.Data<Number, Number> data : currentFunction.getData()) {
//                data.getNode().setStyle("");
//            }
        }
    }

    public void hideFunction() {
        if (currentFunction != null) {
            currentFunction.setStyle("-fx-stroke: transparent;");
//            for (XYChart.Data<Number, Number> data : currentFunction.getData()) {
//                data.getNode().setStyle("-fx-background-color: transparent;");
//            }
        }
    }


}

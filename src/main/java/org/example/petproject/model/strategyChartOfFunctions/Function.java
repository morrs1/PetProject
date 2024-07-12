package org.example.petproject.model.strategyChartOfFunctions;

import javafx.scene.Node;
import javafx.scene.chart.XYChart;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Function {
    private Node Function;
    private String colorOfFunction;
    private Boolean isShowed;
    private XYChart.Series<Number, Number> series;
    private String width;
    private String Name;
    private String rangeFrom;
    private String rangeTo;
}

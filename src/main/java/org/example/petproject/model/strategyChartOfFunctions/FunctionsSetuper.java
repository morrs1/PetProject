package org.example.petproject.model.strategyChartOfFunctions;

import javafx.scene.chart.XYChart;

public class FunctionsSetuper {
    public static XYChart.Series<Number, Number> sinFunc() {
        XYChart.Series<Number, Number> sinSeries = new XYChart.Series<>();

        for (double x = -1 * Math.PI; x <=1 * Math.PI; x += 0.5) {
            sinSeries.getData().add(new XYChart.Data<>(x, Math.sin(x)));
        }
        return sinSeries;
    }
    public static XYChart.Series<Number, Number> cosFunc() {
        XYChart.Series<Number, Number> cosSeries = new XYChart.Series<>();

        for (double x = -1 * Math.PI; x <=1 * Math.PI; x += 0.5) {
            cosSeries.getData().add(new XYChart.Data<>(x, Math.cos(x)));
        }
        return cosSeries;
    }
    public static XYChart.Series<Number, Number> expFunc() {
        XYChart.Series<Number, Number> expSeries = new XYChart.Series<>();

        for (double x = -1 * Math.PI; x <=1 * Math.PI; x += 0.5) {
            expSeries.getData().add(new XYChart.Data<>(x, Math.exp(x)));
        }
        return expSeries;
    }
}

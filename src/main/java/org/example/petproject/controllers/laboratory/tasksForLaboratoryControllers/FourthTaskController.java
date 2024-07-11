package org.example.petproject.controllers.laboratory.tasksForLaboratoryControllers;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import org.example.petproject.controllers.BaseController;

public class FourthTaskController extends BaseController {
    @FXML
    LineChart<Number, Number> chartForFunctions;

    @FXML
    protected void onShowButtonClick() {
        chartForFunctions.setLegendVisible(false);
        XYChart.Series<Number, Number> sinSeries = new XYChart.Series<>();

// Заполняем Series данными
        for (double x = -0.2 * Math.PI; x <= 0.2 * Math.PI; x += 0.1) {
            sinSeries.getData().add(new XYChart.Data<>(x, Math.sin(x)));
        }

// Добавляем Series в LineChart

        chartForFunctions.getData().add(sinSeries);
        for (XYChart.Data<Number, Number> data : sinSeries.getData()) {
            Node point = data.getNode();
            point.setStyle(
                    "-fx-background-color: blue;"
            );
        }
        chartForFunctions.lookup(".series0").setStyle("-fx-stroke-width: 2px;" + "-fx-stroke: blue;");

    }
}

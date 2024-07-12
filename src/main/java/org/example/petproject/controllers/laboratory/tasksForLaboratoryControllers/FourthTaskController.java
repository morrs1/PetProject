package org.example.petproject.controllers.laboratory.tasksForLaboratoryControllers;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.VBox;
import org.example.petproject.controllers.BaseController;
import org.example.petproject.model.strategyChartOfFunctions.ChartOfFunction;

import java.net.URL;
import java.util.ResourceBundle;

public class FourthTaskController extends BaseController implements Initializable {
    @FXML
    LineChart<Number, Number> chartForFunctions;
    @FXML
    ComboBox<String> comboBoxForFunctions;
    @FXML
    VBox vBoxForFunctions;
    @FXML
    RadioButton showButton;

    ChartOfFunction chartOfFunction = new ChartOfFunction();

    @FXML
    protected void onShowButtonClick() {
        chartOfFunction.setCurrentFunction(chartForFunctions.lookup(".series0"));
        if(!showButton.isSelected()){
            chartOfFunction.hideFunction();
        }else {
            chartOfFunction.showFunction();
        }

//        chartForFunctions.setLegendVisible(false);
//        XYChart.Series<Number, Number> sinSeries = new XYChart.Series<>();
//
//// Заполняем Series данными
//        for (double x = -0.1 * Math.PI; x <= 0.1 * Math.PI; x += 0.01) {
//            sinSeries.getData().add(new XYChart.Data<>(x, Math.sin(x)));
//        }
//
//// Добавляем Series в LineChart
//
//        chartForFunctions.getData().add(sinSeries);
//        for (XYChart.Data<Number, Number> data : sinSeries.getData()) {
//            Node point = data.getNode();
//            point.setStyle(
//                    "-fx-background-color: blue;"
//            );
//        }
//
//        chartForFunctions.lookup(".series0").setStyle("-fx-stroke-width: 2px;" + "-fx-stroke: blue;");
//        XYChart.Series<Number, Number> cosSeries = new XYChart.Series<>();
//
//// Заполняем Series данными
//        for (double x = -1 * Math.PI; x <= 1 * Math.PI; x += 0.1) {
//            cosSeries.getData().add(new XYChart.Data<>(x, Math.cos(x)));
//        }
//
//// Добавляем Series в LineChart
//
//        chartForFunctions.getData().add(cosSeries);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        vBoxForFunctions.getChildren().forEach(vBox -> {
            ObservableList<Node> innerVBoxChildren = ((VBox) vBox).getChildren();
            comboBoxForFunctions.getItems().add(((Label) innerVBoxChildren.getLast()).getText());
        });
        chartForFunctions.setLegendVisible(false);
        XYChart.Series<Number, Number> sinSeries = new XYChart.Series<>();

// Заполняем Series данными
        for (double x = -10 * Math.PI; x <= 10 * Math.PI; x += 0.5) {
            sinSeries.getData().add(new XYChart.Data<>(x, Math.sin(x)));
        }

// Добавляем Series в LineChart

        chartForFunctions.getData().add(sinSeries);
        for (XYChart.Data<Number, Number> data : sinSeries.getData()) {
            Node point = data.getNode();
            point.setStyle(
                    "-fx-background-color: transparent;"
            );
        }
//        chartOfFunction.setCurrentFunction(chartForFunctions.lookup(".series0"));
    }
}

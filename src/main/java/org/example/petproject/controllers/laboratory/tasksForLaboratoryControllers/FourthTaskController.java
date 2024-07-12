package org.example.petproject.controllers.laboratory.tasksForLaboratoryControllers;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import org.example.petproject.controllers.BaseController;
import org.example.petproject.model.strategyChartOfFunctions.ChartOfFunction;
import org.example.petproject.model.strategyChartOfFunctions.FunctionsSetuper;

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
    @FXML
    TextField textFieldForWidth;

    ChartOfFunction chartOfFunction = new ChartOfFunction();

    @FXML
    protected void onShowButtonClick() {

        if (!showButton.isSelected()) {
            chartOfFunction.hideFunction();
        } else {
            chartOfFunction.showFunction();
        }
    }


    protected void onWidthButtonChangeValue() {
        textFieldForWidth.textProperty().addListener((observable, oldValue, newValue) -> {
            chartOfFunction.changeWidthOfFunction(newValue);
            System.out.println(newValue);
        });

    }

    @FXML
    protected void handleComboBoxAction(ActionEvent event) {
        switch (comboBoxForFunctions.getSelectionModel().getSelectedItem()) {
            case "y(x)=sin(x)" -> {
                chartOfFunction.setCurrentFunction(chartForFunctions.lookup(".series0"));
                chartOfFunction.setColorOfFunction("rgb(255, 0, 0)");
            }
            case "y(x)=cos(x)" -> {
                chartOfFunction.setCurrentFunction(chartForFunctions.lookup(".series1"));
                chartOfFunction.setColorOfFunction("rgb(0, 0, 255)");
            }
            case "y(x)=exp(x)" -> {
                chartOfFunction.setCurrentFunction(chartForFunctions.lookup(".series2"));
                chartOfFunction.setColorOfFunction("rgb(0, 255, 0)");
            }
        }
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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        vBoxForFunctions.getChildren().forEach(vBox -> {
            ObservableList<Node> innerVBoxChildren = ((VBox) vBox).getChildren();
            comboBoxForFunctions.getItems().add(((Label) innerVBoxChildren.getLast()).getText());
        });
        chartForFunctions.setLegendVisible(false);

        var sinSeries = FunctionsSetuper.sinFunc();
        var cosSeries = FunctionsSetuper.cosFunc();
        var expSeries = FunctionsSetuper.expFunc();
        chartForFunctions.getData().add(sinSeries);
        chartForFunctions.getData().add(cosSeries);
        chartForFunctions.getData().add(expSeries);
        for (XYChart.Data<Number, Number> data : sinSeries.getData()) {
            Node point = data.getNode();
            point.setStyle(
                    "-fx-background-color: transparent;"
            );
        }
        for (XYChart.Data<Number, Number> data : cosSeries.getData()) {
            Node point = data.getNode();
            point.setStyle(
                    "-fx-background-color: transparent;"
            );
        }
        for (XYChart.Data<Number, Number> data : expSeries.getData()) {
            Node point = data.getNode();
            point.setStyle(
                    "-fx-background-color: transparent;"
            );
        }
        chartForFunctions.lookup(".series0").setStyle("-fx-stroke-width: 2px;" + "-fx-stroke: transparent;");
        chartForFunctions.lookup(".series1").setStyle("-fx-stroke-width: 2px;" + "-fx-stroke: transparent;");
        chartForFunctions.lookup(".series2").setStyle("-fx-stroke-width: 2px;" + "-fx-stroke: transparent;");
        onWidthButtonChangeValue();
        chartOfFunction.setCurrentFunction(chartForFunctions.lookup(".series0"));
    }
}

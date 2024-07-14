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
import org.example.petproject.model.strategyChartOfFunctions.Function;
import org.example.petproject.model.strategyChartOfFunctions.FunctionsSetuper;

import java.net.URL;
import java.util.Objects;
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
    @FXML
    TextField textFieldFrom;
    @FXML
    TextField textFieldTo;

    ChartOfFunction chartOfFunction = new ChartOfFunction();

    Function sinFunction;
    Function cosFunction;
    Function expFunction;
    Boolean isUserUpdate = true;

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
        });

    }

    protected void onRangeFieldsChangeValue() {
        textFieldFrom.textProperty().addListener((observable, oldValue, newValue) -> {
            if (isUserUpdate) {
                updateSinFunction();
            }
        });
        textFieldTo.textProperty().addListener((observable, oldValue, newValue) -> {
            if (isUserUpdate) {
                updateSinFunction();
            }
        });
    }


    @FXML
    protected void handleComboBoxAction() {
        switch (comboBoxForFunctions.getSelectionModel().getSelectedItem()) {
            case "y(x)=sin(x)" -> setupUIWhenSwitchFunction(sinFunction);

            case "y(x)=cos(x)" -> setupUIWhenSwitchFunction(cosFunction);

            case "y(x)=exp(x)" -> setupUIWhenSwitchFunction(expFunction);
        }
    }


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
        sinFunction = new Function(chartForFunctions.lookup(".series0"), "rgb(255, 0, 0)", false, sinSeries, "2", "sin", "-3", "3");
        cosFunction = new Function(chartForFunctions.lookup(".series1"), "rgb(0, 0, 255)", false, cosSeries, "2", "cos", "-3", "3");
        expFunction = new Function(chartForFunctions.lookup(".series2"), "rgb(0, 255, 0)", false, expSeries, "2", "exp", "-3", "3");
        onWidthButtonChangeValue();
        onRangeFieldsChangeValue();
    }

    private void updateSinFunction() {

        if (textFieldFrom.getText().matches("-?\\d+(\\.\\d+)?") && textFieldTo.getText().matches("-?\\d+(\\.\\d+)?")
                && Double.parseDouble(textFieldFrom.getText()) < Double.parseDouble(textFieldTo.getText())) {

            chartOfFunction.getCurrentFunction().getSeries().getData().clear();
            if (Objects.equals(chartOfFunction.getCurrentFunction().getName(), "sin")) {
                System.out.println("ff");
                for (double x = Double.parseDouble(textFieldFrom.getText()); x <= Double.parseDouble(textFieldTo.getText()); x += 0.05) {
                    chartOfFunction.getCurrentFunction().getSeries().getData().add(new XYChart.Data<>(x, Math.sin(x)));

                }
            }

            if (Objects.equals(chartOfFunction.getCurrentFunction().getName(), "cos")) {
                System.out.println("dd");
                for (double x = Double.parseDouble(textFieldFrom.getText()); x <= Double.parseDouble(textFieldTo.getText()); x += 0.05) {
                    chartOfFunction.getCurrentFunction().getSeries().getData().add(new XYChart.Data<>(x, Math.cos(x)));

                }
            }

            if (Objects.equals(chartOfFunction.getCurrentFunction().getName(), "exp")) {
                System.out.println("aa");
                for (double x = Double.parseDouble(textFieldFrom.getText()); x <= Double.parseDouble(textFieldTo.getText()); x += 0.05) {
                    chartOfFunction.getCurrentFunction().getSeries().getData().add(new XYChart.Data<>(x, Math.exp(x)));
                }
            }
            chartOfFunction.getCurrentFunction().setRangeFrom(textFieldFrom.getText());
            chartOfFunction.getCurrentFunction().setRangeTo(textFieldTo.getText());
            System.out.println("sin " + sinFunction.getRangeFrom() + " " + sinFunction.getRangeTo());
            System.out.println("cos " + cosFunction.getRangeFrom() + " " + cosFunction.getRangeTo());
            System.out.println("exp " + expFunction.getRangeFrom() + " " + expFunction.getRangeTo());
        }
        for (XYChart.Data<Number, Number> data : chartOfFunction.getCurrentFunction().getSeries().getData()) {
            Node point = data.getNode();
            point.setStyle("-fx-background-color: transparent;");
        }
    }

    private void setupUIWhenSwitchFunction(Function function) {
        chartOfFunction.setCurrentFunction(function);
        showButton.setSelected(function.getIsShowed());
        textFieldForWidth.setText(function.getWidth());
        isUserUpdate = false;
        textFieldFrom.setText(function.getRangeFrom());
        textFieldTo.setText(function.getRangeTo());
        isUserUpdate = true;
    }

}

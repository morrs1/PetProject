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
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import org.example.petproject.controllers.BaseController;
import org.example.petproject.model.strategyChartOfFunctions.ChartOfFunction;
import org.example.petproject.model.strategyChartOfFunctions.MyFunction;
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

    MyFunction sinMyFunction;
    MyFunction cosMyFunction;
    MyFunction expMyFunction;
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
        textFieldForWidth.textProperty().addListener((observable, oldValue, newValue) -> chartOfFunction.changeWidthOfFunction(newValue));
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
            case "y(x)=sin(x)" -> setupUIWhenSwitchFunction(sinMyFunction);

            case "y(x)=cos(x)" -> setupUIWhenSwitchFunction(cosMyFunction);

            case "y(x)=exp(x)" -> setupUIWhenSwitchFunction(expMyFunction);
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
        makePointsTransparent(sinSeries);
        makePointsTransparent(cosSeries);
        makePointsTransparent(expSeries);
        chartForFunctions.lookup(".series0").setStyle("-fx-stroke-width: 2px;" + "-fx-stroke: transparent;");
        chartForFunctions.lookup(".series1").setStyle("-fx-stroke-width: 2px;" + "-fx-stroke: transparent;");
        chartForFunctions.lookup(".series2").setStyle("-fx-stroke-width: 2px;" + "-fx-stroke: transparent;");
        sinMyFunction = new MyFunction(chartForFunctions.lookup(".series0"), "rgb(255, 0, 0)", false, sinSeries, "2", "sin", "-3", "3");
        cosMyFunction = new MyFunction(chartForFunctions.lookup(".series1"), "rgb(0, 0, 255)", false, cosSeries, "2", "cos", "-3", "3");
        expMyFunction = new MyFunction(chartForFunctions.lookup(".series2"), "rgb(0, 255, 0)", false, expSeries, "2", "exp", "-3", "3");
        onWidthButtonChangeValue();
        onRangeFieldsChangeValue();
    }

    private void updateSinFunction() {

        if (textFieldFrom.getText().matches("-?\\d+(\\.\\d+)?") && textFieldTo.getText().matches("-?\\d+(\\.\\d+)?")
                && Double.parseDouble(textFieldFrom.getText()) < Double.parseDouble(textFieldTo.getText())) {

            chartOfFunction.getCurrentMyFunction().getSeries().getData().clear();
            if (Objects.equals(chartOfFunction.getCurrentMyFunction().getName(), "sin")) {
                for (double x = Double.parseDouble(textFieldFrom.getText()); x <= Double.parseDouble(textFieldTo.getText()); x += 0.05) {
                    chartOfFunction.getCurrentMyFunction().getSeries().getData().add(new XYChart.Data<>(x, Math.sin(x)));

                }
            }

            if (Objects.equals(chartOfFunction.getCurrentMyFunction().getName(), "cos")) {
                for (double x = Double.parseDouble(textFieldFrom.getText()); x <= Double.parseDouble(textFieldTo.getText()); x += 0.05) {
                    chartOfFunction.getCurrentMyFunction().getSeries().getData().add(new XYChart.Data<>(x, Math.cos(x)));

                }
            }

            if (Objects.equals(chartOfFunction.getCurrentMyFunction().getName(), "exp")) {
                for (double x = Double.parseDouble(textFieldFrom.getText()); x <= Double.parseDouble(textFieldTo.getText()); x += 0.05) {
                    chartOfFunction.getCurrentMyFunction().getSeries().getData().add(new XYChart.Data<>(x, Math.exp(x)));
                }
            }
            chartOfFunction.getCurrentMyFunction().setRangeFrom(textFieldFrom.getText());
            chartOfFunction.getCurrentMyFunction().setRangeTo(textFieldTo.getText());
        }
        for (XYChart.Data<Number, Number> data : chartOfFunction.getCurrentMyFunction().getSeries().getData()) {
            Node point = data.getNode();
            point.setStyle("-fx-background-color: transparent;");
        }
    }

    private void setupUIWhenSwitchFunction(MyFunction myFunction) {
        chartOfFunction.setCurrentMyFunction(myFunction);
        showButton.setSelected(myFunction.getIsShowed());
        textFieldForWidth.setText(myFunction.getWidth());
        isUserUpdate = false;
        textFieldFrom.setText(myFunction.getRangeFrom());
        textFieldTo.setText(myFunction.getRangeTo());
        isUserUpdate = true;
    }

    private void makePointsTransparent(XYChart.Series<Number, Number> series) {
        for (XYChart.Data<Number, Number> data : series.getData()) {
            Node point = data.getNode();
            point.setStyle(
                    "-fx-background-color: transparent;"
            );
        }
    }

}

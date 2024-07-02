package org.example.petproject.controllers.laboratory.tasksForLaboratoryControllers;


import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Shape;
import org.example.petproject.controllers.BaseController;
import org.example.petproject.model.secondTask.ModifiedCircleShape;
import org.example.petproject.model.secondTask.Painter;
import org.example.petproject.model.secondTask.ShapeFactory;
import org.example.petproject.model.strategyShapes.AbstractShape;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class ThirdTaskController extends BaseController implements Initializable {
    @FXML
    ToggleGroup secondTaskToggleButtonsGroup;
    @FXML
    ColorPicker colorPickerForContour;
    @FXML
    ColorPicker colorPikerForFill;
    @FXML
    TextField textFieldForWidthOfContour;
    @FXML
    ComboBox<String> comboBoxForTypeOfContour;
    @FXML
    AnchorPane paneForThirdTask;
    Painter painter;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Arrays.asList("Dotted", "Solid").forEach(value -> comboBoxForTypeOfContour.getItems().add(value));
    }

    @FXML
    protected void onPaneForFigureClick(MouseEvent mouseEvent) {
        System.out.println(((ToggleButton) secondTaskToggleButtonsGroup.getSelectedToggle()).getChildrenUnmodifiable() + " " +
                colorPikerForFill.getValue() + " " + colorPickerForContour.getValue() + " " +
                textFieldForWidthOfContour.getText() + " " + comboBoxForTypeOfContour.getValue());

        ModifiedCircleShape m = (ModifiedCircleShape) ShapeFactory.create((Shape) (((ToggleButton) secondTaskToggleButtonsGroup.getSelectedToggle()).getChildrenUnmodifiable().getFirst()),
                colorPickerForContour.getValue(), colorPikerForFill.getValue(), Integer.parseInt(textFieldForWidthOfContour.getText()),
                comboBoxForTypeOfContour.getValue());
        assert m != null;
        paneForThirdTask.getChildren().add(m.getShape());
    }
}

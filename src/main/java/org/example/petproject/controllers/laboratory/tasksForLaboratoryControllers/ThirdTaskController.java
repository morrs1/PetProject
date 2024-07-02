package org.example.petproject.controllers.laboratory.tasksForLaboratoryControllers;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import org.example.petproject.controllers.BaseController;
import org.example.petproject.model.secondTask.ModifiedCircleShape;
import org.example.petproject.model.secondTask.Painter;
import org.example.petproject.model.secondTask.ShapeFactory;


import java.net.URL;
import java.util.Arrays;
import java.util.Objects;
import java.util.ResourceBundle;

public class ThirdTaskController extends BaseController implements Initializable {
    @FXML
    ToggleGroup thirdTaskToggleButtonsGroup;
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

    Painter painter = new Painter();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Arrays.asList("Dotted", "Solid").forEach(value -> comboBoxForTypeOfContour.getItems().add(value));

    }

    @FXML
    protected void onPaneForFigureClick(MouseEvent mouseEvent) {

        if (!Objects.equals(textFieldForWidthOfContour.getText(), "")) {

            ModifiedCircleShape newShape = (ModifiedCircleShape) ShapeFactory.create((Shape)
                            (((ToggleButton) thirdTaskToggleButtonsGroup.getSelectedToggle()).getChildrenUnmodifiable().getFirst()),
                    colorPickerForContour.getValue(),
                    colorPikerForFill.getValue(),
                    Integer.parseInt(textFieldForWidthOfContour.getText()),
                    comboBoxForTypeOfContour.getValue(), mouseEvent.getX(), mouseEvent.getY());


            if (painter.getCurrentShape() != null) {
                var previousShape = painter.getCurrentShape().getShape();
                Color colorOfBuffShape = (Color) previousShape.getStroke();
                previousShape.setStroke(new Color(colorOfBuffShape.getRed(), colorOfBuffShape.getGreen(), colorOfBuffShape.getBlue(), 1));
            }
            painter.setCurrentShape(newShape);
            paneForThirdTask.getChildren().add(newShape.getShape());
        }
    }
}

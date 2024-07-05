package org.example.petproject.controllers.laboratory.tasksForLaboratoryControllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import org.example.petproject.controllers.BaseController;
import org.example.petproject.core.classes.FileSaver;
import org.example.petproject.core.enums.Directions;
import org.example.petproject.model.secondTask.Painter;
import org.example.petproject.model.secondTask.ShapeFactory;
import org.example.petproject.model.strategyShapes.AbstractShape;


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
    @FXML
    TextField heightForImageToSave;
    @FXML
    TextField widthForImageToSave;
    @FXML
    Button buttonForSave;
    @FXML
    Button buttonForHelp;
    @FXML
    Button backButton;
    @FXML
    Button exitButton;
    @FXML
    AnchorPane mainPaneThirdTask;

    Tooltip tooltipForHelp = new Tooltip("Это приложение выполняет функцию графического редактора,\n " +
            "настройте изображение " +
            "в правой панели и щелкните лкм по левой панели,\n после добавления на панель фигуры, вы можете изменять " +
            "ее размеры \n(клавиши \"<\" \">\" \"+\" \"-\" и менять ее расположение на клавиши стрелок ");
    Painter painter = new Painter();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Arrays.asList("Dotted", "Solid").forEach(value -> comboBoxForTypeOfContour.getItems().add(value));
    }

    @FXML
    protected void onPaneForFigureClick(MouseEvent mouseEvent) {
        mainPaneThirdTask.requestFocus();

        if (!Objects.equals(textFieldForWidthOfContour.getText(), "") && !Objects.equals(comboBoxForTypeOfContour.getValue(), null)
                && thirdTaskToggleButtonsGroup.getSelectedToggle() != null) {

            AbstractShape newShape = ShapeFactory.create((Shape)
                            (((ToggleButton) thirdTaskToggleButtonsGroup.getSelectedToggle()).getChildrenUnmodifiable().getFirst()),
                    colorPickerForContour.getValue(),
                    colorPikerForFill.getValue(),
                    Integer.parseInt(textFieldForWidthOfContour.getText()),
                    comboBoxForTypeOfContour.getValue(), mouseEvent.getX(), mouseEvent.getY());


            if (painter.getCurrentShape() != null) {
                if (painter.getCurrentShape().getRectangle().getStroke() != null) {
                    var previousRectangle = painter.getCurrentShape().getRectangle();
                    Color colorOfRectangle = (Color) previousRectangle.getStroke();
                    previousRectangle.setStroke(new Color(colorOfRectangle.getRed(), colorOfRectangle.getGreen(), colorOfRectangle.getBlue(), 1));
                } else {
                    var previousShape = painter.getCurrentShape().getShape();
                    Color colorOfBuffShape = (Color) previousShape.getStroke();
                    previousShape.setStroke(new Color(colorOfBuffShape.getRed(), colorOfBuffShape.getGreen(), colorOfBuffShape.getBlue(), 1));
                }
            }
            painter.setCurrentShape(newShape);
            paneForThirdTask.getChildren().add(newShape.getShape());
            paneForThirdTask.getChildren().add(newShape.getRectangle());
        }
    }

    @FXML
    protected void onKeyPressed(KeyEvent keyEvent) {
        if (painter.getCurrentShape() != null) {
            switch (keyEvent.getCode()) {
                case UP, DOWN, LEFT, RIGHT -> onArrowsPressed(keyEvent);
                case EQUALS, MINUS -> onPlusMinusPressed(keyEvent);
                case COMMA, PERIOD -> onLessGreaterPressed(keyEvent);
            }
        }
    }

    @FXML
    protected void onSaveButtonClick() {
        FileSaver.saveFile(paneForThirdTask.snapshot(null, null), "png",
                Integer.parseInt(widthForImageToSave.getText()), Integer.parseInt(heightForImageToSave.getText()));
    }

    @FXML
    protected void onHelpButtonPressed(MouseEvent mouseEvent) {
        tooltipForHelp.show(buttonForHelp, mouseEvent.getScreenX(), mouseEvent.getScreenY());
    }

    @FXML
    protected void onHelpButtonReleased(MouseEvent mouseEvent) {
        tooltipForHelp.hide();
    }

    private void onArrowsPressed(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case UP -> painter.getCurrentShape().moveShapeAndFrame(2, 2, Directions.UP);
            case DOWN -> painter.getCurrentShape().moveShapeAndFrame(2, 2, Directions.DOWN);
            case LEFT -> painter.getCurrentShape().moveShapeAndFrame(2, 2, Directions.LEFT);
            case RIGHT -> painter.getCurrentShape().moveShapeAndFrame(2, 2, Directions.RIGHT);
        }
    }

    private void onPlusMinusPressed(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case EQUALS -> painter.getCurrentShape().changeSize(Directions.UP);
            case MINUS -> painter.getCurrentShape().changeSize(Directions.DOWN);
        }
    }

    private void onLessGreaterPressed(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case COMMA -> painter.getCurrentShape().changeSize(Directions.LEFT);
            case PERIOD -> painter.getCurrentShape().changeSize(Directions.RIGHT);
        }
    }

}

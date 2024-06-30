package org.example.petproject.controllers.laboratory.tasksForLaboratoryControllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Ellipse;
import org.example.petproject.controllers.BaseController;
import org.example.petproject.core.enums.Directions;
import org.example.petproject.model.strategyShapes.AbstractShape;
import org.example.petproject.model.strategyShapes.CircleShape;


import java.net.URL;
import java.util.ResourceBundle;

public class SecondTaskController extends BaseController implements Initializable {
    @FXML
    AnchorPane paneForShape;
    @FXML
    Button backButton;
    @FXML
    Button exitButton;
    AbstractShape shape;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        backButton.setFocusTraversable(false);
        exitButton.setFocusTraversable(false);
        paneForShape.setFocusTraversable(true);
        shape = new CircleShape(new Ellipse());
        paneForShape.getChildren().add(shape.getShape());
        paneForShape.getChildren().add(shape.getFrame());
    }

    @FXML
    protected void onKeyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case UP,DOWN,LEFT,RIGHT -> onArrowsPressed(keyEvent);
            case EQUALS,MINUS ->  onPlusMinusPressed(keyEvent);
            case COMMA,PERIOD -> onLessGreaterPressed(keyEvent);
        }
    }

    private void onArrowsPressed(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case UP -> shape.moveShapeAndFrame(2,2, Directions.UP);
            case DOWN -> shape.moveShapeAndFrame(2,2, Directions.DOWN);
            case LEFT -> shape.moveShapeAndFrame(2,2, Directions.LEFT);
            case RIGHT -> shape.moveShapeAndFrame(2,2, Directions.RIGHT);
        }
    }

    private void onPlusMinusPressed(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case EQUALS -> shape.changeSize(Directions.UP);
            case MINUS -> shape.changeSize(Directions.DOWN);
        }
    }

    private void onLessGreaterPressed(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case COMMA -> shape.changeSize(Directions.LEFT);
            case PERIOD -> shape.changeSize(Directions.RIGHT);
        }
    }


}

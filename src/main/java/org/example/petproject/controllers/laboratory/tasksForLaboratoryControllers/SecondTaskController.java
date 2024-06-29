package org.example.petproject.controllers.laboratory.tasksForLaboratoryControllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import org.example.petproject.controllers.BaseController;
import org.example.petproject.model.strategyShapes.AbstractShape;
import org.example.petproject.model.strategyShapes.LineShape;

import java.net.URL;
import java.util.ResourceBundle;

public class SecondTaskController extends BaseController implements Initializable {
    @FXML
    AnchorPane paneForShape;
    AbstractShape shape;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        shape = new LineShape(new Line());
        paneForShape.getChildren().add(shape.getShape());
    }

    @FXML
    protected void onKeyPressed(KeyEvent keyEvent) {

    }

}

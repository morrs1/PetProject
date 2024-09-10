package org.example.petproject.controllers.laboratory.tasksForLaboratoryControllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.example.petproject.controllers.BaseController;
;

public class NinthTaskController extends BaseController {
    @FXML
    TextField textFieldForAmountOfPoints;
    @FXML
    Button buttonForPaintPoints;
    @FXML
    AnchorPane paneForPoints;

    @FXML
    protected void onButtonForPaintPointsClicked() {
        paneForPoints.getChildren().add(new javafx.scene.control.Label(textFieldForAmountOfPoints.getText()));
    }
}

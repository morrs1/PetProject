package org.example.petproject.controllers.laboratory.secondLabControllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.example.petproject.controllers.BaseController;
import org.example.petproject.model.secondLaboratoryRequests.RequestSender;

import java.io.IOException;
import java.net.*;
import java.util.Arrays;
import java.util.Objects;
import java.util.ResourceBundle;

public class SecondLaboratoryWindowController extends BaseController implements Initializable {
    @FXML
    ComboBox<String> comboBoxForTypeOfRequest;
    @FXML
    TextField textFieldForRequest;
    @FXML
    Button enterButtonForRequest;
    @FXML
    Label labelForResponse;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Arrays.asList("GET", "POST").forEach(value -> comboBoxForTypeOfRequest.getItems().add(value));
    }

    @FXML
    public void enterButtonForRequestClicked() throws IOException, URISyntaxException, InterruptedException {
        String typeOfRequest = comboBoxForTypeOfRequest.getSelectionModel().getSelectedItem();
        if(typeOfRequest != null) {
            labelForResponse.setText(RequestSender.sendRequest(typeOfRequest));
        }

    }
}

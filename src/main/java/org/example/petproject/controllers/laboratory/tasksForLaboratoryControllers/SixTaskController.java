package org.example.petproject.controllers.laboratory.tasksForLaboratoryControllers;

import javafx.fxml.Initializable;
import org.example.petproject.controllers.BaseController;
import org.example.petproject.core.xyz.ParserXYZ;

import java.net.URL;
import java.util.ResourceBundle;

public class SixTaskController extends BaseController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println(ParserXYZ.parseXYZ("src/main/resources/org/example/petproject/XYZs/firstMolecule.xyz"));
    }
}

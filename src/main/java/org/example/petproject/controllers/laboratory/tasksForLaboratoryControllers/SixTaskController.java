package org.example.petproject.controllers.laboratory.tasksForLaboratoryControllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import org.example.petproject.controllers.BaseController;
import org.example.petproject.controllers.SceneController;
import org.example.petproject.core.classes.SceneLoader;
import org.example.petproject.core.xyz.MoleculeXYZ;
import org.example.petproject.core.xyz.ParserXYZ;

import java.net.URL;
import java.util.ResourceBundle;

public class SixTaskController extends BaseController {
    @FXML
    AnchorPane anchorPaneForMolecule;
    @FXML
    Button button;
    private MoleculeXYZ molecule;

    @FXML
    protected void onButtonClick() {
        double widthOfPane = anchorPaneForMolecule.getWidth();
        Double heightOfPane = anchorPaneForMolecule.getHeight();
        molecule = ParserXYZ.parseXYZ("src/main/resources/org/example/petproject/XYZs/firstMolecule.xyz");
        molecule.descriptionOfAtoms().forEach((key, value) -> value.forEach(atom -> {
            Sphere sphere = new Sphere(30);
            sphere.setTranslateX(widthOfPane / 2 + atom.getFirst());
            sphere.setTranslateY(heightOfPane / 2 - atom.get(1));
            sphere.setTranslateZ(atom.get(2));
            anchorPaneForMolecule.getChildren().add(sphere);
        }));


        Platform.runLater(() -> {
            System.out.println(SceneController.getInstance().getStage().getScene().fillProperty());
            SceneController.getInstance().getStage().getScene().setCamera(new PerspectiveCamera());
        });
    }
}

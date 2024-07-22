package org.example.petproject.controllers.laboratory.tasksForLaboratoryControllers;


import javafx.fxml.FXML;

import javafx.geometry.Point3D;

import javafx.scene.PerspectiveCamera;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;

import javafx.scene.shape.Sphere;

import org.example.petproject.controllers.BaseController;
import org.example.petproject.controllers.SceneController;

import org.example.petproject.core.xyz.MoleculeXYZ;
import org.example.petproject.core.xyz.ParserXYZ;



public class SixTaskController extends BaseController {
    @FXML
    AnchorPane anchorPaneForMolecule;
    @FXML
    Button button;
    private MoleculeXYZ molecule;

    @FXML
    protected void onButtonClick() {
        double widthOfPane = anchorPaneForMolecule.getWidth();
        double heightOfPane = anchorPaneForMolecule.getHeight();
        molecule = ParserXYZ.parseXYZ("src/main/resources/org/example/petproject/XYZs/firstMolecule.xyz");
        molecule.descriptionOfAtoms().forEach((key, value) -> value.forEach(atom -> {
            for (var value1 : molecule.descriptionOfAtoms().values()) {
                for (var index = 0; index < value1.size() - 1; index++) {
                    anchorPaneForMolecule.getChildren().add(
                            MoleculeXYZ.createConnection(new Point3D(widthOfPane / 2 + value1.get(index).getFirst()
                                            , heightOfPane / 2 - value1.get(index).get(1), value1.get(index).get(2))
                                    , new Point3D(widthOfPane / 2 + value1.get(index + 1).getFirst()
                                            , heightOfPane / 2 - value1.get(index + 1).get(1), value1.get(index + 1).get(2))));
                }
            }
            Sphere sphere = new Sphere(30);
            sphere.setTranslateX(widthOfPane / 2 + atom.getFirst());
            sphere.setTranslateY(heightOfPane / 2 - atom.get(1));
            sphere.setTranslateZ(atom.get(2));
            sphere.setMaterial(new PhongMaterial(Color.BLUE));

            anchorPaneForMolecule.getChildren().add(sphere);

        }));

        SceneController.getInstance().getStage().getScene().setCamera(new PerspectiveCamera());

    }

}

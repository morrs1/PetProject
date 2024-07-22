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
            Sphere sphere = new Sphere(30);
            sphere.setTranslateX(widthOfPane / 2 + atom.getX());
            sphere.setTranslateY(heightOfPane / 2 - atom.getY());
            sphere.setTranslateZ(atom.getZ());
            sphere.setMaterial(new PhongMaterial(Color.BLUE));

            anchorPaneForMolecule.getChildren().add(sphere);

        }));
        for (var index = 0; index < molecule.amountOfAtoms(); index++) {
            for (var innerIndex = 0; innerIndex < molecule.amountOfAtoms(); innerIndex++) {
                anchorPaneForMolecule.getChildren().add(
                        MoleculeXYZ.createConnection(
                                new Point3D(
                                        widthOfPane / 2 + molecule.allAtoms().get(index).getX(),
                                        heightOfPane / 2 - molecule.allAtoms().get(index).getY(),
                                        molecule.allAtoms().get(index).getZ()
                                ),
                                new Point3D(
                                        widthOfPane / 2 + molecule.allAtoms().get(innerIndex).getX(),
                                        heightOfPane / 2 - molecule.allAtoms().get(innerIndex).getY(),
                                        molecule.allAtoms().get(innerIndex).getZ()
                                )
                        ));
            }
        }
        molecule.allAtoms().forEach(System.out::println);
        SceneController.getInstance().getStage().getScene().setCamera(new PerspectiveCamera());

    }

}

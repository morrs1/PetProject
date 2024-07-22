package org.example.petproject.controllers.laboratory.tasksForLaboratoryControllers;


import javafx.application.Platform;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.geometry.Point3D;

import javafx.scene.PerspectiveCamera;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.paint.PhongMaterial;

import javafx.scene.shape.Sphere;

import javafx.scene.transform.Rotate;
import org.example.petproject.controllers.BaseController;
import org.example.petproject.controllers.SceneController;

import org.example.petproject.core.classes.FileSaver;
import org.example.petproject.core.classes.SceneLoader;
import org.example.petproject.core.enums.Scenes;
import org.example.petproject.core.xyz.MoleculeXYZ;
import org.example.petproject.core.xyz.ParserXYZ;

import java.net.URL;
import java.util.ResourceBundle;


public class SixTaskController extends BaseController implements Initializable {
    @FXML
    AnchorPane mainAnchorPaneForMolecule;
    @FXML
    ComboBox<String> comboBoxForFiles;
    @FXML
    ComboBox<String> comboBoxForExtension;
    private MoleculeXYZ molecule;
    private AnchorPane paneForMolecule;
    private PerspectiveCamera camera;

    @FXML
    protected void onSaveButtonClick() {
        if(comboBoxForExtension.getValue()!=null) {
            FileSaver.saveFile(
                    paneForMolecule.snapshot(null, null),
                    comboBoxForExtension.getValue(),
                    (int) paneForMolecule.getWidth(),
                    (int) paneForMolecule.getHeight());
            paneForMolecule.requestFocus();
        }
    }

    @FXML
    protected void onComboBoxValueClick() {
        double widthOfPane = paneForMolecule.getWidth();
        double heightOfPane = paneForMolecule.getHeight();
        System.out.println(widthOfPane + " " + heightOfPane);

        molecule = ParserXYZ.parseXYZ("src/main/resources/org/example/petproject/XYZs/firstMolecule.xyz");
        molecule.descriptionOfAtoms().forEach((key, value) -> value.forEach(atom -> {
            Sphere sphere = new Sphere(50);
            sphere.setTranslateX(widthOfPane / 2 + atom.getX());
            sphere.setTranslateY(heightOfPane / 2 - atom.getY());
            sphere.setTranslateZ(atom.getZ());
            sphere.setMaterial(new PhongMaterial(Color.BLUE));

            paneForMolecule.getChildren().add(sphere);

        }));
        for (var index = 0; index < molecule.amountOfAtoms(); index++) {
            for (var innerIndex = 0; innerIndex < molecule.amountOfAtoms(); innerIndex++) {
                paneForMolecule.getChildren().add(
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
//        SceneController.getInstance().getStage().getScene().setCamera(new PerspectiveCamera());
        paneForMolecule.requestFocus();
        paneForMolecule.setStyle("-fx-background-color: transparent;");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Platform.runLater(() -> {
            var root = (AnchorPane) SceneLoader.getInstance().getScenes().get(Scenes.SIXTH_TASK_WINDOW.getName()).getRoot();
            paneForMolecule = new AnchorPane();
            SubScene subScene = new SubScene(
                    paneForMolecule, 500,
                    442, true, SceneAntialiasing.BALANCED
            );
            subScene.setTranslateY(58);
            System.out.println(subScene.getWidth() + " " + subScene.getHeight());
            camera = new PerspectiveCamera();
//            camera.setTranslateX(camera.getTranslateX() +100);
//            camera.setTranslateY(camera.getTranslateY() +100);
            camera.setTranslateZ(camera.getTranslateZ() - 1000);
//            camera.setNearClip(-1000);
//            camera.setFarClip(1000);
            subScene.setCamera(camera);
            paneForMolecule.setStyle("-fx-background-color:  #A9A9A9");
            root.getChildren().add(subScene);
//            subScene.setOnMousePressed(this::handleMousePressed);
//            subScene.setOnMouseDragged(this::handleMouseDragged);
            subScene.getScene().setOnScroll(this::handleScroll);
            System.out.println(camera.getNearClip());
            camera.setFarClip(1000);
            subScene.getScene().setOnKeyPressed((KeyEvent event) -> {
                if (event.getCode() == KeyCode.DOWN) {
                    paneForMolecule.getTransforms().add(new Rotate(5, Rotate.Y_AXIS));
                }
                if (event.getCode() == KeyCode.UP) {
                    paneForMolecule.getTransforms().add(new Rotate(5, Rotate.X_AXIS));
                }
                if (event.getCode() == KeyCode.LEFT) {
                    paneForMolecule.getTransforms().add(new Rotate(5, Rotate.Z_AXIS));
                }
            });
        });
        comboBoxForFiles.getItems().add("xyz1");
        comboBoxForExtension.getItems().add("png");
        comboBoxForExtension.getItems().add("jpg");
        comboBoxForExtension.getItems().add("gif");
    }

    private void handleScroll(ScrollEvent event) {
        if (event.getDeltaY() > 0) {
            paneForMolecule.setScaleX(paneForMolecule.getScaleX() + 0.05);
            paneForMolecule.setScaleY(paneForMolecule.getScaleY() + 0.05);
            paneForMolecule.setScaleZ(paneForMolecule.getScaleZ() + 0.05);
        } else {
            if (paneForMolecule.getScaleX() > 0.05) {
                paneForMolecule.setScaleX(paneForMolecule.getScaleX() - 0.05);
                paneForMolecule.setScaleY(paneForMolecule.getScaleY() - 0.05);
                paneForMolecule.setScaleZ(paneForMolecule.getScaleZ() - 0.05);
            }
        }
    }
}

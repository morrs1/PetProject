package org.example.petproject.controllers.laboratory.tasksForLaboratoryControllers;


import javafx.application.Platform;
import javafx.event.Event;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.geometry.Point3D;

import javafx.scene.PerspectiveCamera;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;

import javafx.scene.shape.Sphere;

import javafx.scene.transform.Rotate;
import org.example.petproject.controllers.BaseController;

import org.example.petproject.core.classes.FileSaver;
import org.example.petproject.core.classes.SceneLoader;
import org.example.petproject.core.enums.Scenes;
import org.example.petproject.core.xyz.MoleculeXYZ;
import org.example.petproject.core.xyz.ParserXYZ;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.stream.IntStream;


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
    Label labelForDescription;
    @FXML
    Label labelForAtom;
    @FXML
    ComboBox<String> comboBoxForAtom;
    @FXML
    ColorPicker colorPicker;
    ArrayList<Sphere> listForSpheres = new ArrayList<>();
    Sphere currentSphere;

    @FXML
    protected void onSaveButtonClick() {
        if (comboBoxForExtension.getValue() != null) {
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
        comboBoxForAtom.getItems().clear();
        listForSpheres.clear();
        colorPicker.setValue(Color.WHITE);
        labelForAtom.setText("");
        currentSphere = null;
        double widthOfPane = paneForMolecule.getWidth();
        double heightOfPane = paneForMolecule.getHeight();
        paneForMolecule.getChildren().clear();
        molecule = ParserXYZ.parseXYZ("src/main/resources/org/example/petproject/XYZs/" + comboBoxForFiles.getValue() + ".xyz");
        molecule.setColorOfAtomsByType();
        molecule.reColorAtoms();
        molecule.descriptionOfAtoms().forEach((key, value) -> value.forEach(atom -> {
            Sphere sphere = new Sphere(50);
            sphere.setTranslateX(widthOfPane / 2 + atom.getX());
            sphere.setTranslateY(heightOfPane / 2 - atom.getY());
            sphere.setTranslateZ(atom.getZ());
            sphere.setMaterial(new PhongMaterial(atom.getColor()));
            sphere.setAccessibleText(atom.getName());
            listForSpheres.add(sphere);
            paneForMolecule.getChildren().add(sphere);

        }));
        IntStream.range(1, listForSpheres.size() + 1).forEach(x -> comboBoxForAtom.getItems().add(String.valueOf(x)));

        colorPicker.setOnAction((event -> {
            if (colorPicker.getValue() != null && currentSphere != null) {
                currentSphere.setMaterial(new PhongMaterial(colorPicker.getValue()));
            }
        }));
        createAllConnections();

        labelForDescription.setText(molecule.descriptionOfMolecule());

        paneForMolecule.requestFocus();
        paneForMolecule.setStyle("-fx-background-color: transparent;");


    }

    private void createAllConnections() {
        for (var index = 0; index < molecule.amountOfAtoms(); index++) {
            for (var innerIndex = 0; innerIndex < molecule.amountOfAtoms(); innerIndex++) {
                paneForMolecule.getChildren().add(
                        MoleculeXYZ.createConnection(
                                new Point3D(
                                        listForSpheres.get(index).getTranslateX(),
                                        listForSpheres.get(index).getTranslateY(),
                                        listForSpheres.get(index).getTranslateZ()
                                ),
                                new Point3D(
                                        listForSpheres.get(innerIndex).getTranslateX(),
                                        listForSpheres.get(innerIndex).getTranslateY(),
                                        listForSpheres.get(innerIndex).getTranslateZ()
                                )
                        ));
            }
        }
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
            camera = new PerspectiveCamera();

            camera.setTranslateZ(camera.getTranslateZ() - 1000);

            subScene.setCamera(camera);
            paneForMolecule.setStyle("-fx-background-color:  #A9A9A9");
            root.getChildren().add(subScene);

            subScene.getScene().setOnScroll(this::handleScroll);
            camera.setFarClip(1000);
            subScene.getScene().setOnKeyPressed(this::subSceneOnKeyPressed);
        });
        comboBoxForAtom.setOnAction(this::comboBoxForAtomValueClicked);
        comboBoxForFiles.getItems().add("firstMolecule");
        comboBoxForFiles.getItems().add("secondMolecule");
        comboBoxForFiles.getItems().add("thirdMolecule");
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

    private void comboBoxForAtomValueClicked(Event event) {
        if (comboBoxForAtom.getValue() != null) {
            colorPicker.setValue(((PhongMaterial) listForSpheres.get(Integer.parseInt(comboBoxForAtom.getValue()) - 1).getMaterial()).getDiffuseColor());
            labelForAtom.setText(listForSpheres.get(Integer.parseInt(comboBoxForAtom.getValue()) - 1).getAccessibleText());
            currentSphere = listForSpheres.get(Integer.parseInt(comboBoxForAtom.getValue()) - 1);
        }
    }

    private void subSceneOnKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.DOWN) {
            paneForMolecule.getTransforms().add(new Rotate(5, Rotate.Y_AXIS));
        }
        if (event.getCode() == KeyCode.UP) {
            paneForMolecule.getTransforms().add(new Rotate(5, Rotate.X_AXIS));
        }
        if (event.getCode() == KeyCode.LEFT) {
            paneForMolecule.getTransforms().add(new Rotate(5, Rotate.Z_AXIS));
        }
    }
}

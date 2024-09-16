package org.example.petproject.model.ninthTask;

import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Sphere;

import java.util.stream.IntStream;

public class PointsDrawer {
    public static void draw(Integer amountOfPoints, AnchorPane paneForPoints) {
        paneForPoints.getChildren().clear();
        IntStream.range(0, amountOfPoints).forEach(point -> {
            Sphere newSphere = new Sphere();
            newSphere.setRadius(10);
            newSphere.setTranslateX(point * 40);
            paneForPoints.getChildren().add(newSphere);
            if (!(point == amountOfPoints - 1)) {
                var line = new Line();
                line.setStartX(newSphere.getTranslateX());
                line.setStartY(newSphere.getTranslateY());
                line.setEndX(newSphere.getTranslateX() + 40);
                line.setEndY(newSphere.getTranslateY());
                paneForPoints.getChildren().add(line);
            }

        });
    }
}

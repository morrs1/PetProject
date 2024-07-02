package org.example.petproject.model.secondTask;

import javafx.scene.shape.Ellipse;
import org.example.petproject.model.strategyShapes.CircleShape;

public class ModifiedCircleShape extends CircleShape {

    public ModifiedCircleShape(Ellipse circle) {
        super(circle);
        setupFrame();
    }

}

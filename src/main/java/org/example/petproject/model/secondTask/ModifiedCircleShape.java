package org.example.petproject.model.secondTask;

import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import org.example.petproject.model.strategyShapes.CircleShape;

public class ModifiedCircleShape extends CircleShape {
    private ModifiedCircleShape(Ellipse circle, Integer radius) {
        super(circle, radius);
    }

    public ModifiedCircleShape(Ellipse circle) {
        super(circle);
    }
    @Override
    protected void setupFrame() {
        Rectangle currentFrame = new Rectangle(
                circle.getCenterX() - circle.getRadiusX() - 2,
                circle.getCenterY() - circle.getRadiusY() - 2,
                2 * circle.getRadiusX() + 4,
                2 * circle.getRadiusY() + 4
        );

        currentFrame = setupRectangle(currentFrame);
        setFrame(currentFrame);
    }


}

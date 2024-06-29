package org.example.petproject.model.strategyShapes;

import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import lombok.Getter;
import org.example.petproject.core.enums.Directions;


@Getter
public abstract class AbstractShape {
    private Rectangle frame;

    public abstract void setupFrame();
    public abstract void moveShapeAndFrame(Integer x, Integer y, Directions direction);
    public abstract void changeSize(Directions direction);
    protected abstract void setupShape();
    public abstract Shape getShape();
}

package org.example.petproject.model.strategyShapes;

import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import lombok.Getter;
import lombok.Setter;
import org.example.petproject.core.enums.Directions;


@Getter
@Setter
public abstract class AbstractShape {
    private Rectangle frame;

    protected abstract void setupFrame();
    public abstract void moveShapeAndFrame(Integer x, Integer y, Directions direction);
    public abstract void changeSize(Directions direction);
    protected abstract void setupShape();
    public abstract Shape getShape();
}

package org.example.petproject.model.strategyShapes;

import javafx.scene.shape.Shape;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.petproject.core.enums.Directions;
import javafx.scene.shape.Line;


public class LineShape extends AbstractShape {
    private final Line line;

public LineShape(Line line) {
    this.line = line;
    setupShape();
}
    @Override
    public void setupFrame() {

    }

    @Override
    protected void setupShape() {
    line.setStartX(100);
    line.setStartY(100);
    line.setEndX(300);
    line.setEndY(300);
    }

    @Override
    public Shape getShape() {
        return line;
    }

    @Override
    public void moveShapeAndFrame(Integer x, Integer y, Directions direction) {

    }

    @Override
    public void changeSize(Directions direction) {

    }


}

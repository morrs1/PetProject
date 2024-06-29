package org.example.petproject.model.strategyShapes;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
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
        setupFrame();
    }

    @Override
    public void setupFrame() {
        Rectangle currentFrame = new Rectangle(
                line.getStartX() - 2,
                line.getStartY() - 2,
                Math.abs(line.getStartY() - line.getEndY() - 5),
                Math.abs(line.getStartX() - line.getEndX() - 5)
        );
        currentFrame.setFill(Color.TRANSPARENT);
        currentFrame.setStroke(Color.BLACK);
        currentFrame.setStrokeWidth(3.0f);
        currentFrame.getStrokeDashArray().addAll(10.0, 20.0);
        currentFrame.setOpacity(0.5);
        setFrame(currentFrame);
    }

    @Override
    protected void setupShape() {
        line.setStrokeWidth(5);
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
        int dx = (direction == Directions.LEFT ? -x : (direction == Directions.RIGHT ? x : 0));
        int dy = (direction == Directions.UP ? -y : (direction == Directions.DOWN ? y : 0));

        line.setStartX(line.getStartX() + dx);
        line.setEndX(line.getEndX() + dx);
        line.setStartY(line.getStartY() + dy);
        line.setEndY(line.getEndY() + dy);

        getFrame().setX(getFrame().getX() + dx);
        getFrame().setY(getFrame().getY() + dy);
    }

    @Override
    public void changeSize(Directions direction) {
        switch (direction) {
            case UP -> {
                line.setEndY(line.getEndY() - 1);
                getFrame().setHeight(getFrame().getHeight() - 1);
            }
            case DOWN -> {
                line.setEndY(line.getEndY() + 1);
                getFrame().setHeight(getFrame().getHeight() + 1);
            }
            case LEFT -> {
                line.setEndX(line.getEndX() - 1);
                getFrame().setWidth(getFrame().getWidth() - 1);
            }
            case RIGHT -> {
                line.setEndX(line.getEndX() + 1);
                getFrame().setWidth(getFrame().getWidth() + 1);
            }
        }
    }


}

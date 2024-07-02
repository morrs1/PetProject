package org.example.petproject.model.secondTask;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Shape;
import lombok.Setter;
import org.example.petproject.model.strategyShapes.AbstractShape;
import org.example.petproject.model.strategyShapes.CircleShape;

@Setter
public class ShapeFactory {
    public static AbstractShape create(Shape shape, Color colorOfContour, Color colorOfFill,
                                       Integer widthOfContour, String typeOfContour) {

        AbstractShape finalShape = switch (shape.getClass().getSimpleName()) {
            case "Circle" -> {
                Ellipse copiedShape = new Ellipse();
                copiedShape.setRadiusX(50);
                copiedShape.setRadiusY(50);
                copiedShape.setCenterX(100);
                copiedShape.setCenterY(100);
                copiedShape.setFill(colorOfFill);
                copiedShape.setStroke(colorOfContour);
                copiedShape.setStrokeWidth(widthOfContour);
                if(typeOfContour.equals("Dotted")){
                    copiedShape.getStrokeDashArray().addAll(10.0, 10.0);
                }
                yield new ModifiedCircleShape(copiedShape);
            }
            default -> throw new IllegalStateException("Unexpected value: " + shape.getClass().getSimpleName());
        };


        return finalShape;
    }
}

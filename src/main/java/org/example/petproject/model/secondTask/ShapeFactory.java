package org.example.petproject.model.secondTask;

import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Shape;
import lombok.Setter;
import org.example.petproject.model.strategyShapes.AbstractShape;


@Setter
public class ShapeFactory {
    public static AbstractShape create(Shape shape, Color colorOfContour, Color colorOfFill,
                                       Integer widthOfContour, String typeOfContour, Double centerX, Double centerY) {

        AbstractShape finalShape = switch (shape.getClass().getSimpleName()) {
            case "Circle" -> {
                Ellipse copiedShape = new Ellipse();
                copiedShape.setRadiusX(50);
                copiedShape.setRadiusY(50);
                copiedShape.setCenterX(centerX);
                copiedShape.setCenterY(centerY);
                copiedShape.setFill(colorOfFill);
                copiedShape.setStroke(new Color(colorOfContour.getRed(), colorOfContour.getGreen(), colorOfContour.getBlue(), 0.3));
                copiedShape.setStrokeWidth(widthOfContour);
                if (typeOfContour.equals("Dotted")) {
                    copiedShape.getStrokeDashArray().addAll(10.0, 10.0);
                }
                yield new ModifiedCircleShape(copiedShape);
            }
            default -> throw new IllegalStateException("Unexpected value: " + shape.getClass().getSimpleName());
        };


        return finalShape;
    }
}

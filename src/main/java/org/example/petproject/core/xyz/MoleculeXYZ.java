package org.example.petproject.core.xyz;

import javafx.geometry.Point3D;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Cylinder;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public record MoleculeXYZ(Integer amountOfAtoms, String descriptionOfMolecule,
                          LinkedHashMap<String, ArrayList<Atom>> descriptionOfAtoms) {

    public static Cylinder createConnection(Point3D origin, Point3D target) {
        Point3D yAxis = new Point3D(0, 1, 0);
        Point3D diff = target.subtract(origin);

        double height = diff.magnitude();
        Point3D mid = target.midpoint(origin);
        var moveToMidpoint = new Translate(mid.getX(), mid.getY(), mid.getZ());
        Point3D axisOfRotation = diff.crossProduct(yAxis);

        double angle = Math.acos(diff.normalize().dotProduct(yAxis));
        Rotate rotateAroundCenter = new Rotate(-Math.toDegrees(angle), axisOfRotation);
        Cylinder line = new Cylinder(3, height);
        line.getTransforms().addAll(moveToMidpoint, rotateAroundCenter);
        line.setMaterial(new PhongMaterial(Color.BLACK));
        return line;
    }
}

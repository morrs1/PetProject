package org.example.petproject.core.xyz;

import javafx.scene.paint.Color;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class Atom {
    private Double x;
    private Double y;
    private Double z;
    @Setter
    private Color color;
    private String Name;
}

package org.example.petproject.model.secondTask;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.petproject.model.strategyShapes.AbstractShape;



@Setter
@Getter
@AllArgsConstructor
public class Painter {
    private AbstractShape currentShape;


}

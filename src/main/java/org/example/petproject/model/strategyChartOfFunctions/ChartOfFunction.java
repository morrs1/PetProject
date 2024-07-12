package org.example.petproject.model.strategyChartOfFunctions;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChartOfFunction {
   private Function currentFunction;

    public void showFunction() {
        if (currentFunction != null) {
            currentFunction.getFunction().setStyle(currentFunction.getFunction().getStyle() + "-fx-stroke: " + currentFunction.getColorOfFunction() + ";");
            currentFunction.setIsShowed(true);
        }
    }

    public void hideFunction() {
        if (currentFunction != null) {
            currentFunction.getFunction().setStyle(currentFunction.getFunction().getStyle() +"-fx-stroke: transparent;");
            currentFunction.setIsShowed(false);
        }
    }

    public void changeWidthOfFunction(String width){
        if (currentFunction != null && !width.isEmpty()) {
            currentFunction.getFunction().setStyle(currentFunction.getFunction().getStyle() + "-fx-stroke-width: " + width + ";");
            currentFunction.setWidth(width);
        }
    }

}

package org.example.petproject.model.strategyChartOfFunctions;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChartOfFunction {
   private MyFunction currentMyFunction;

    public void showFunction() {
        if (currentMyFunction != null) {
            currentMyFunction.getFunction().setStyle(currentMyFunction.getFunction().getStyle() + "-fx-stroke: " + currentMyFunction.getColorOfFunction() + ";");
            currentMyFunction.setIsShowed(true);
        }
    }

    public void hideFunction() {
        if (currentMyFunction != null) {
            currentMyFunction.getFunction().setStyle(currentMyFunction.getFunction().getStyle() +"-fx-stroke: transparent;");
            currentMyFunction.setIsShowed(false);
        }
    }

    public void changeWidthOfFunction(String width){
        if (currentMyFunction != null && !width.isEmpty()) {
            currentMyFunction.getFunction().setStyle(currentMyFunction.getFunction().getStyle() + "-fx-stroke-width: " + width + ";");
            currentMyFunction.setWidth(width);
        }
    }

}

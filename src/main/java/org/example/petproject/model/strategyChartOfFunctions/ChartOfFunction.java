package org.example.petproject.model.strategyChartOfFunctions;


import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Getter
@Setter
public class ChartOfFunction {
   private MyFunction currentMyFunction;
   public static Map<String, Function<Double, Double>> functions = new HashMap<>() {{
       put("sin", Math::sin);
       put("cos", Math::cos);
       put("exp", Math::exp);
   }};

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

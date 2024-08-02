package org.example.petproject.model.strategyAnimations;

import javafx.animation.Transition;
import lombok.Setter;

@Setter
public class AnimationOfShape {
    private Transition animation;

    public void applyAnimation() {
        animation.play();
    }
}

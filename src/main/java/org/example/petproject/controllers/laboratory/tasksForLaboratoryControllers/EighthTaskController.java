package org.example.petproject.controllers.laboratory.tasksForLaboratoryControllers;

import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import org.example.petproject.controllers.BaseController;
import org.example.petproject.model.strategyAnimations.AnimationOfShape;

public class EighthTaskController extends BaseController {
    @FXML
    Rectangle shapeForAnimation;

    private final AnimationOfShape animationOfShape = new AnimationOfShape();

    @FXML
    protected void onFadeInButtonClicked() {
        FadeTransition fadeInTransition = new FadeTransition(Duration.seconds(1), shapeForAnimation);
        fadeInTransition.setFromValue(0);
        fadeInTransition.setToValue(1);
        animationOfShape.setAnimation(fadeInTransition);
        animationOfShape.applyAnimation();
    }

    @FXML
    protected void onFadeOutButtonClicked() {
        FadeTransition fadeOutTransition = new FadeTransition(Duration.seconds(1), shapeForAnimation);
        fadeOutTransition.setFromValue(1);
        fadeOutTransition.setToValue(0);
        animationOfShape.setAnimation(fadeOutTransition);
        animationOfShape.applyAnimation();
    }

    @FXML
    protected void onRotateButtonClicked() {
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(2), shapeForAnimation);
        rotateTransition.setFromAngle(0);
        rotateTransition.setToAngle(360);
        animationOfShape.setAnimation(rotateTransition);
        animationOfShape.applyAnimation();
    }

    @FXML
    protected void onMoveButtonClicked() {
        TranslateTransition moveTransitionTo = new TranslateTransition(Duration.seconds(1), shapeForAnimation);
        moveTransitionTo.setFromX(shapeForAnimation.getX());
        moveTransitionTo.setToX(shapeForAnimation.getX() + 30);
        moveTransitionTo.setOnFinished(event -> {
            TranslateTransition moveTransitionBack = new TranslateTransition(Duration.seconds(1), shapeForAnimation);
            moveTransitionBack.setFromX(shapeForAnimation.getX() + 30);
            moveTransitionBack.setToX(shapeForAnimation.getX());
            animationOfShape.setAnimation(moveTransitionBack);
            animationOfShape.applyAnimation();
        });
        animationOfShape.setAnimation(moveTransitionTo);
        animationOfShape.applyAnimation();

    }

    @FXML
    protected void onScaleButtonClicked() {
        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(1), shapeForAnimation);
        scaleTransition.setFromX(1);
        scaleTransition.setToX(1.2);
        scaleTransition.setFromY(1);
        scaleTransition.setToY(1.2);
        scaleTransition.setOnFinished(event -> {
            ScaleTransition scaleTransitionBack = new ScaleTransition(Duration.seconds(1), shapeForAnimation);
            scaleTransitionBack.setFromX(1.2);
            scaleTransitionBack.setToX(1);
            scaleTransitionBack.setFromY(1.2);
            scaleTransitionBack.setToY(1);
            animationOfShape.setAnimation(scaleTransitionBack);
            animationOfShape.applyAnimation();
        });
        animationOfShape.setAnimation(scaleTransition);
        animationOfShape.applyAnimation();
    }
}

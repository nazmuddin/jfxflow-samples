package com.zenjava.samples.simpleflow;

import com.zenjava.jfxflow.actvity.AbstractActivity;
import com.zenjava.jfxflow.transition.AbstractViewTransition;
import com.zenjava.jfxflow.transition.HasEntryTransition;
import com.zenjava.jfxflow.transition.HasExitTransition;
import com.zenjava.jfxflow.transition.ViewTransition;
import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

public class CustomTransitionExampleActivity extends AbstractActivity
        implements HasEntryTransition, HasExitTransition
{
    @FXML private VBox animationPane;

    private List<Label> labels;
    private ViewTransition entryTransition;
    private ViewTransition exitTransition;

    @PostConstruct
    private void init()
    {
        Node node = getView().toNode();
        labels = new ArrayList<Label>();
        for (int i = 1; i <= 9; i++)
        {
            labels.add((Label) animationPane.lookup(String.format("#label%s", i)));
        }

        // create entry transition

        entryTransition = new AbstractViewTransition()
        {
            public void setupBeforeAnimation(Bounds bounds)
            {
                for (int i = 0; i < labels.size(); i++)
                {
                    Label label = labels.get(i);
                    label.setOpacity(0);
                    if (i == labels.size() - 1)
                    {
                        label.setScaleX(0);
                        label.setScaleY(0);
                    }
                    else if (i % 2 == 1)
                    {
                        label.setTranslateY(20);
                    }
                }
            }

            public Animation getAnimation()
            {
                SequentialTransition animation = new SequentialTransition();

                for (int i = 0; i < 8; i++)
                {
                    Label label = labels.get(i);
                    ParallelTransition labelAnimation = new ParallelTransition(label);
                    labelAnimation.setDelay(Duration.millis(200));

                    FadeTransition fadeIn = new FadeTransition(Duration.millis(300));
                    fadeIn.setInterpolator(Interpolator.EASE_BOTH);
                    fadeIn.setToValue(1);
                    labelAnimation.getChildren().add(fadeIn);

                    if (i % 2 == 1)
                    {
                        TranslateTransition translate = new TranslateTransition(Duration.millis(600));
                        fadeIn.setDuration(Duration.millis(1000));
                        translate.setInterpolator(Interpolator.EASE_OUT);
                        translate.setFromY(20);
                        translate.setToY(0);
                        labelAnimation.getChildren().add(translate);
                    }

                    animation.getChildren().add(labelAnimation);
                }

                // at the end fade out everyone and scale in the finale

                ParallelTransition parallel = new ParallelTransition();
                for (int i = 0; i < labels.size() - 1; i++)
                {
                    Label label = labels.get(i);
                    FadeTransition fadeOut = new FadeTransition(Duration.millis(500), label);
                    fadeOut.setInterpolator(Interpolator.EASE_BOTH);
                    fadeOut.setToValue(0);
                    parallel.getChildren().add(fadeOut);
                }

                Label label = labels.get(labels.size() - 1);

                FadeTransition fadeIn = new FadeTransition(Duration.millis(300), label);
                fadeIn.setDelay(Duration.millis(300));
                fadeIn.setInterpolator(Interpolator.EASE_BOTH);
                fadeIn.setToValue(1);
                parallel.getChildren().add(fadeIn);

                ScaleTransition scale = new ScaleTransition(Duration.millis(1500), label);
                scale.setDelay(Duration.millis(300));
                scale.setInterpolator(Interpolator.EASE_BOTH);
                scale.setFromX(0);
                scale.setFromY(0);
                scale.setToX(1);
                scale.setToY(1);
                parallel.getChildren().add(scale);

                animation.getChildren().add(parallel);

                return animation;
            }
        };

        // create exit transition

        exitTransition = new AbstractViewTransition()
        {
            public Animation getAnimation()
            {
                Label label = labels.get(labels.size() - 1);
                ParallelTransition animation = new ParallelTransition();

                ScaleTransition scale = new ScaleTransition(Duration.millis(1000), label);
                scale.setInterpolator(Interpolator.EASE_IN);
                scale.setFromX(1);
                scale.setFromY(1);
                scale.setToX(10);
                scale.setToY(10);
                animation.getChildren().add(scale);

                FadeTransition fadeOut = new FadeTransition(Duration.millis(1000), label);
                fadeOut.setInterpolator(Interpolator.EASE_BOTH);
                fadeOut.setToValue(0);
                animation.getChildren().add(fadeOut);

                return animation;
            }

            public void cleanupAfterAnimation()
            {
                Label label = labels.get(labels.size() - 1);
                label.setScaleX(1);
                label.setScaleY(1);
            }
        };
    }

    public boolean isSequentialTransition()
    {
        return true;
    }

    public ViewTransition getEntryTransition()
    {
        return entryTransition;
    }

    public ViewTransition getExitTransition()
    {
        return exitTransition;
    }
}

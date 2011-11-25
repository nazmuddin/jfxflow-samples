package com.zenjava.samples.simpleflow;

import com.zenjava.jfxflow.actvity.AbstractActivity;
import com.zenjava.jfxflow.transition.*;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
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
        Node node = getNode();
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
                for (Label label : labels)
                {
                    label.setOpacity(0);
                }
            }

            public Animation getAnimation()
            {
                SequentialTransition animation = new SequentialTransition();

                for (Label label : labels)
                {
                    FadeTransition labelFadeIn = new FadeTransition(Duration.millis(300), label);
                    labelFadeIn.setToValue(1);
                    animation.getChildren().add(labelFadeIn);
                }

                return animation;
            }
        };

        exitTransition = new FadeOutTransition(node, Duration.millis(300));
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

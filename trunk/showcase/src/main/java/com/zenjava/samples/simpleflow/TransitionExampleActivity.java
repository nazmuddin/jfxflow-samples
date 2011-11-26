package com.zenjava.samples.simpleflow;

import com.zenjava.jfxflow.actvity.AbstractActivity;
import com.zenjava.jfxflow.transition.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.util.Duration;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.ResourceBundle;

public class TransitionExampleActivity extends AbstractActivity
        implements HasEntryTransition, HasExitTransition
{
    enum Type { fade, fly }

    @FXML private Label messageLabel;
    @Autowired private ResourceBundle resources;
    private Type type;

    public void setType(Type type)
    {
        this.type = type;
    }

    @PostConstruct
    private void init()
    {
        messageLabel.setText(resources.getString(String.format("transitionExample.message.%s", type.name())));
    }

    public ViewTransition getEntryTransition()
    {
        switch (type)
        {
            case fade:
                return new FadeInTransition(getNode(), Duration.millis(800));
            case fly:
                return FlyTransition.createFlyIn(getNode(), Duration.millis(800), VerticalPosition.top);
            default:
                throw new IllegalArgumentException(String.format("Unsupported type: %s", type));
        }
    }

    public ViewTransition getExitTransition()
    {
        switch (type)
        {
            case fade:
                return new FadeOutTransition(getNode(), Duration.millis(800));
            case fly:
                return FlyTransition.createFlyOut(getNode(), Duration.millis(800),
                        HorizontalPosition.right, VerticalPosition.bottom);
            default:
                throw new IllegalArgumentException(String.format("Unsupported type: %s", type));
        }
    }
}

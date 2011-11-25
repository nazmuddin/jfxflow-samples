package com.zenjava.samples.simpleflow;

import com.zenjava.jfxflow.actvity.AbstractActivity;
import com.zenjava.jfxflow.navigation.NavigationManager;
import com.zenjava.jfxflow.navigation.Place;
import javafx.event.ActionEvent;
import org.springframework.beans.factory.annotation.Autowired;

public class TransitionsActivity extends AbstractActivity
{
    @Autowired private NavigationManager navigationManager;

    public void showFadeTransition(ActionEvent event)
    {
        navigationManager.goTo(new Place("transitions/fade"));
    }

    public void showFlyTransition(ActionEvent event)
    {
        navigationManager.goTo(new Place("transitions/fly"));
    }

    public void showCustomTransition(ActionEvent event)
    {
        navigationManager.goTo(new Place("transitions/custom"));
    }
}

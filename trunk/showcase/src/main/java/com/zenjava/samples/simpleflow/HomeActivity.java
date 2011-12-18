package com.zenjava.samples.simpleflow;

import com.zenjava.jfxflow.actvity.AbstractActivity;
import com.zenjava.jfxflow.navigation.NavigationManager;
import com.zenjava.jfxflow.navigation.Place;
import javafx.event.ActionEvent;

import javax.inject.Inject;

public class HomeActivity extends AbstractActivity
{
    @Inject private NavigationManager navigationManager;

    public void goToNavigation(ActionEvent event)
    {
        navigationManager.goTo(new Place("navigation"));
    }

    public void goToTransitions(ActionEvent event)
    {
        navigationManager.goTo(new Place("transitions"));
    }

    public void goToThreading(ActionEvent event)
    {
        navigationManager.goTo(new Place("threading"));
    }

    public void goToDialogs(ActionEvent event)
    {
        navigationManager.goTo(new Place("dialogs"));
    }

    public void goToForms(ActionEvent event)
    {
        navigationManager.goTo(new Place("forms"));
    }
}

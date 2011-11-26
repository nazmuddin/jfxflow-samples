package com.zenjava.samples.simpleflow;

import com.zenjava.jfxflow.actvity.AbstractActivity;
import com.zenjava.jfxflow.navigation.NavigationManager;
import com.zenjava.jfxflow.navigation.Place;
import javafx.event.ActionEvent;
import org.springframework.beans.factory.annotation.Autowired;

public class NavigationActivity extends AbstractActivity
{
    @Autowired private NavigationManager navigationManager;

    public void showBrowserInfo(ActionEvent event)
    {
        navigationManager.goTo(new Place("navigation/browser"));
    }

    public void showActivityInfo(ActionEvent event)
    {
        navigationManager.goTo(new Place("navigation/activity"));
    }

    public void showNavigationManagerInfo(ActionEvent event)
    {
        navigationManager.goTo(new Place("navigation/manager"));
    }
}

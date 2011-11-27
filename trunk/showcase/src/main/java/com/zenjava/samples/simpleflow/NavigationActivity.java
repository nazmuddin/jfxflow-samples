package com.zenjava.samples.simpleflow;

import com.zenjava.jfxflow.actvity.AbstractActivity;
import com.zenjava.jfxflow.navigation.NavigationManager;
import com.zenjava.jfxflow.navigation.Place;
import javafx.event.Event;
import org.springframework.beans.factory.annotation.Autowired;

public class NavigationActivity extends AbstractActivity
{
    @Autowired private NavigationManager navigationManager;

    public void showBrowserInfo(Event event)
    {
        navigationManager.goTo(new Place("navigation/browser"));
    }

    public void showActivityInfo(Event event)
    {
        navigationManager.goTo(new Place("navigation/activity"));
    }

    public void showNavigationManagerInfo(Event event)
    {
        navigationManager.goTo(new Place("navigation/manager"));
    }
}

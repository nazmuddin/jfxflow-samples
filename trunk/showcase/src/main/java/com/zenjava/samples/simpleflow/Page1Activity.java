package com.zenjava.samples.simpleflow;

import com.zenjava.jfxflow.actvity.AbstractActivity;
import com.zenjava.jfxflow.navigation.NavigationManager;
import com.zenjava.jfxflow.navigation.Place;
import javafx.event.ActionEvent;

public class Page1Activity extends AbstractActivity
{
    private NavigationManager navigationManager;

    public void setNavigationManager(NavigationManager navigationManager)
    {
        this.navigationManager = navigationManager;
    }

    public void goToPage2(ActionEvent event)
    {
        navigationManager.goTo(new Place("page2"));
    }
}

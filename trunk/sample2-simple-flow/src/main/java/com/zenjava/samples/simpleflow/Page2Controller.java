package com.zenjava.samples.simpleflow;

import com.zenjava.jfxflow.controller.AbstractController;
import com.zenjava.jfxflow.navigation.NavigationManager;
import javafx.event.ActionEvent;

public class Page2Controller extends AbstractController
{
    private NavigationManager navigationManager;

    public void setNavigationManager(NavigationManager navigationManager)
    {
        this.navigationManager = navigationManager;
    }

    public void goToPage1(ActionEvent event)
    {
        navigationManager.goTo(new Page1Place());
    }
}

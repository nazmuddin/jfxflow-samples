package com.zenjava.samples.simpleflow.page2;

import com.zenjava.jfxflow.controller.AbstractController;
import com.zenjava.jfxflow.navigation.NavigationManager;
import com.zenjava.samples.simpleflow.page1.Page1Place;
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

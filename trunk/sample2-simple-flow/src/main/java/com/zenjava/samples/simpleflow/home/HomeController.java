package com.zenjava.samples.simpleflow.home;

import com.zenjava.jfxflow.controller.AbstractController;
import com.zenjava.jfxflow.navigation.NavigationManager;
import com.zenjava.samples.simpleflow.page1.Page1Place;
import com.zenjava.samples.simpleflow.page2.Page2Place;
import javafx.event.ActionEvent;

public class HomeController extends AbstractController
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

    public void goToPage2(ActionEvent event)
    {
        navigationManager.goTo(new Page2Place());
    }
}

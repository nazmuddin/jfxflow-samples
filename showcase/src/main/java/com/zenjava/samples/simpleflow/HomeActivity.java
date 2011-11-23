package com.zenjava.samples.simpleflow;

import com.zenjava.jfxflow.actvity.AbstractActivity;
import com.zenjava.jfxflow.navigation.NavigationManager;
import com.zenjava.jfxflow.navigation.Place;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.springframework.beans.factory.annotation.Autowired;

public class HomeActivity extends AbstractActivity
{
    @Autowired private NavigationManager navigationManager;
    @FXML

    public void setNavigationManager(NavigationManager navigationManager)
    {
        this.navigationManager = navigationManager;
    }

    public void goToNavigation(ActionEvent event)
    {
        navigationManager.goTo(new Place("navigation"));
    }

    public void goToPage1(ActionEvent event)
    {
        navigationManager.goTo(new Place("page1"));
    }
}

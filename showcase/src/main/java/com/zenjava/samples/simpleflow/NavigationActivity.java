package com.zenjava.samples.simpleflow;

import com.zenjava.jfxflow.actvity.AbstractActivity;
import com.zenjava.jfxflow.navigation.NavigationManager;

public class NavigationActivity extends AbstractActivity
{
    private NavigationManager navigationManager;

    public void setNavigationManager(NavigationManager navigationManager)
    {
        this.navigationManager = navigationManager;
    }
}

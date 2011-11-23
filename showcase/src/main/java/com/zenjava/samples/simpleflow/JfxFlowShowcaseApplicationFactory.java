package com.zenjava.samples.simpleflow;

import com.zenjava.jfxflow.actvity.FxmlLoader;
import com.zenjava.jfxflow.control.Browser;
import com.zenjava.jfxflow.navigation.DefaultNavigationManager;
import com.zenjava.jfxflow.navigation.NavigationManager;
import com.zenjava.jfxflow.navigation.RegexPlaceResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ResourceBundle;

@Configuration
public class JfxFlowShowcaseApplicationFactory
{
    private FxmlLoader loader = new FxmlLoader();

    @Bean
    public Browser browser()
    {
        Browser browser = new Browser(navigationManager(), "JFX Flow Showcase");
        browser.getPlaceResolvers().add(new RegexPlaceResolver("home", homeActivity()));
        browser.getPlaceResolvers().add(new RegexPlaceResolver("navigation", navigationActivity()));
        return browser;
    }

    @Bean
    public NavigationManager navigationManager()
    {
        return new DefaultNavigationManager();
    }

    @Bean
    public HomeActivity homeActivity()
    {
        return loader.load("/fxml/Home.fxml", resources());
    }

    @Bean
    public NavigationActivity navigationActivity()
    {
        return loader.load("/fxml/Navigation.fxml", resources());
    }

    @Bean
    public ResourceBundle resources()
    {
        return ResourceBundle.getBundle("messages/messages");
    }
}

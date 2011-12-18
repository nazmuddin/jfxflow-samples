package com.zenjava.samples.simpleflow;

import com.zenjava.jfxflow.actvity.FxmlLoader;
import com.zenjava.jfxflow.control.Browser;
import com.zenjava.jfxflow.error.DefaultErrorHandler;
import com.zenjava.jfxflow.error.ErrorHandler;
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
        browser.getPlaceResolvers().add(new RegexPlaceResolver("navigation/browser", browserInfoActivity()));
        browser.getPlaceResolvers().add(new RegexPlaceResolver("navigation/activity", actvityInfoActivity()));
        browser.getPlaceResolvers().add(new RegexPlaceResolver("navigation/manager", navigationManagerInfoActivity()));
        browser.getPlaceResolvers().add(new RegexPlaceResolver("transitions", transitionsActivity()));
        browser.getPlaceResolvers().add(new RegexPlaceResolver("transitions/fade", fadeTransitionActivity()));
        browser.getPlaceResolvers().add(new RegexPlaceResolver("transitions/fly", flyTransitionActivity()));
        browser.getPlaceResolvers().add(new RegexPlaceResolver("transitions/custom", customTransitionActivity()));
        browser.getPlaceResolvers().add(new RegexPlaceResolver("threading", threadingActivity()));
        browser.getPlaceResolvers().add(new RegexPlaceResolver("dialogs", dialogsActivity()));
        browser.getPlaceResolvers().add(new RegexPlaceResolver("forms", formsActivity()));
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
    public BrowserInfoActivity browserInfoActivity()
    {
        return loader.load("/fxml/BrowserInfo.fxml", resources());
    }

    @Bean
    public ActvityInfoActivity actvityInfoActivity()
    {
        return loader.load("/fxml/ActivityInfo.fxml", resources());
    }

    @Bean
    public NavigationManagerInfoActivity navigationManagerInfoActivity()
    {
        return loader.load("/fxml/NavigationManagerInfo.fxml", resources());
    }

    @Bean
    public NavigationActivity navigationActivity()
    {
        return loader.load("/fxml/Navigation.fxml", resources());
    }

    @Bean
    public TransitionsActivity transitionsActivity()
    {
        return loader.load("/fxml/Transitions.fxml", resources());
    }

    @Bean
    public TransitionExampleActivity fadeTransitionActivity()
    {
        TransitionExampleActivity activity = loader.load("/fxml/TransitionExample.fxml", resources());
        activity.setType(TransitionExampleActivity.Type.fade);
        return activity;
    }

    @Bean
    public TransitionExampleActivity flyTransitionActivity()
    {
        TransitionExampleActivity activity = loader.load("/fxml/TransitionExample.fxml", resources());
        activity.setType(TransitionExampleActivity.Type.fly);
        return activity;
    }

    @Bean
    public CustomTransitionExampleActivity customTransitionActivity()
    {
        return loader.load("/fxml/CustomTransitionExample.fxml", resources());
    }

    @Bean
    public ThreadingActivity threadingActivity()
    {
        return loader.load("/fxml/Threading.fxml", resources());
    }

    @Bean
    public DialogsActivity dialogsActivity()
    {
        return loader.load("/fxml/Dialogs.fxml", resources());
    }

    @Bean
    public FormsActivity formsActivity()
    {
        return loader.load("/fxml/Forms.fxml", resources());
    }

    @Bean
    public ResourceBundle resources()
    {
        return ResourceBundle.getBundle("messages/messages");
    }

    @Bean
    public ErrorHandler errorHandler()
    {
        return new DefaultErrorHandler(navigationManager());
    }
}

package com.zenjava.samples.simpleflow;

import com.google.inject.AbstractModule;
import com.google.inject.Injector;
import com.google.inject.Provides;
import com.zenjava.jfxflow.actvity.Activity;
import com.zenjava.jfxflow.actvity.FxmlLoader;
import com.zenjava.jfxflow.control.Browser;
import com.zenjava.jfxflow.error.DefaultErrorHandler;
import com.zenjava.jfxflow.error.ErrorHandler;
import com.zenjava.jfxflow.navigation.DefaultNavigationManager;
import com.zenjava.jfxflow.navigation.NavigationManager;
import com.zenjava.jfxflow.navigation.RegexPlaceResolver;

import javax.inject.Named;
import javax.inject.Singleton;
import java.util.ResourceBundle;

public class JfxFlowShowcaseGuiceModule extends AbstractModule
{
    private FxmlLoader loader = new FxmlLoader();

    @Override
    protected void configure()
    {
        bind(NavigationManager.class).to(DefaultNavigationManager.class).in(Singleton.class);
        bind(ErrorHandler.class).to(DefaultErrorHandler.class).in(Singleton.class);
    }

    @Provides
    public Browser browser(NavigationManager navigationManager,
                           HomeActivity homeActivity,
                           NavigationActivity navigationActivity,
                           BrowserInfoActivity browserInfoActivity,
                           ActvityInfoActivity actvityInfoActivity,
                           NavigationManagerInfoActivity navigationManagerInfoActivity,
                           TransitionsActivity transitionsActivity,
                           @Named("fade") TransitionExampleActivity fadeTransitionActivity,
                           @Named("fly") TransitionExampleActivity flyTransitionActivity,
                           CustomTransitionExampleActivity customTransitionExampleActivity,
                           ThreadingActivity threadingActivity,
                           DialogsActivity dialogsActivity,
                           FormsActivity formsActivity)
    {
        Browser browser = new Browser(navigationManager, "JFX Flow Showcase");

        browser.getPlaceResolvers().add(new RegexPlaceResolver("home", homeActivity));
        browser.getPlaceResolvers().add(new RegexPlaceResolver("navigation", navigationActivity));
        browser.getPlaceResolvers().add(new RegexPlaceResolver("navigation/browser", browserInfoActivity));
        browser.getPlaceResolvers().add(new RegexPlaceResolver("navigation/activity", actvityInfoActivity));
        browser.getPlaceResolvers().add(new RegexPlaceResolver("navigation/manager", navigationManagerInfoActivity));
        browser.getPlaceResolvers().add(new RegexPlaceResolver("transitions", transitionsActivity));
        browser.getPlaceResolvers().add(new RegexPlaceResolver("transitions/fade", fadeTransitionActivity));
        browser.getPlaceResolvers().add(new RegexPlaceResolver("transitions/fly", flyTransitionActivity));
        browser.getPlaceResolvers().add(new RegexPlaceResolver("transitions/custom", customTransitionExampleActivity));
        browser.getPlaceResolvers().add(new RegexPlaceResolver("threading", threadingActivity));
        browser.getPlaceResolvers().add(new RegexPlaceResolver("dialogs", dialogsActivity));
        browser.getPlaceResolvers().add(new RegexPlaceResolver("forms", formsActivity));
        return browser;
    }

    @Provides
    public HomeActivity homeActivity(Injector injector)
    {
        return loadAndInjectActivity(injector, "/fxml/Home.fxml");
    }

    @Provides
    public BrowserInfoActivity browserInfoActivity(Injector injector)
    {
        return loadAndInjectActivity(injector, "/fxml/BrowserInfo.fxml");
    }

    @Provides
    public ActvityInfoActivity actvityInfoActivity(Injector injector)
    {
        return loadAndInjectActivity(injector, "/fxml/ActivityInfo.fxml");
    }

    @Provides
    public NavigationManagerInfoActivity navigationManagerInfoActivity(Injector injector)
    {
        return loadAndInjectActivity(injector, "/fxml/NavigationManagerInfo.fxml");
    }

    @Provides
    public NavigationActivity navigationActivity(Injector injector)
    {
        return loadAndInjectActivity(injector, "/fxml/Navigation.fxml");
    }

    @Provides
    public TransitionsActivity transitionsActivity(Injector injector)
    {
        return loadAndInjectActivity(injector, "/fxml/Transitions.fxml");
    }

    @Provides
    @Named("fade")
    public TransitionExampleActivity fadeTransitionActivity(Injector injector)
    {
        TransitionExampleActivity activity = loadAndInjectActivity(injector, "/fxml/TransitionExample.fxml");
        activity.setType(TransitionExampleActivity.Type.fade);
        return activity;
    }

    @Provides
    @Named("fly")
    public TransitionExampleActivity flyTransitionActivity(Injector injector)
    {
        TransitionExampleActivity activity = loadAndInjectActivity(injector, "/fxml/TransitionExample.fxml");
        activity.setType(TransitionExampleActivity.Type.fly);
        return activity;
    }

    @Provides
    public CustomTransitionExampleActivity customTransitionExampleActivity(Injector injector)
    {
        return loadAndInjectActivity(injector, "/fxml/CustomTransitionExample.fxml");
    }

    @Provides
    public ThreadingActivity threadingActivity(Injector injector)
    {
        return loadAndInjectActivity(injector, "/fxml/Threading.fxml");
    }

    @Provides
    public DialogsActivity dialogsActivity(Injector injector)
    {
        return loadAndInjectActivity(injector, "/fxml/Dialogs.fxml");
    }

    @Provides
    public FormsActivity formsActivity(Injector injector)
    {
        return loadAndInjectActivity(injector, "/fxml/Forms.fxml");
    }

    @Provides
    public ResourceBundle resources()
    {
        return ResourceBundle.getBundle("messages/messages");
    }
    
    protected <T extends Activity> T loadAndInjectActivity(Injector injector, String fxmlFile)
    {
        Activity activity = loader.load(fxmlFile, resources());
        injector.injectMembers(activity);
        return (T)activity;
    }
}

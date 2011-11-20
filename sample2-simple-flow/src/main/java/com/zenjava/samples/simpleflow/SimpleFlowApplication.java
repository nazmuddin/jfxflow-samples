package com.zenjava.samples.simpleflow;

import com.zenjava.jfxflow.actvity.FxmlLoader;
import com.zenjava.jfxflow.control.Browser;
import com.zenjava.jfxflow.navigation.DefaultNavigationManager;
import com.zenjava.jfxflow.navigation.Place;
import com.zenjava.jfxflow.navigation.RegexPlaceResolver;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SimpleFlowApplication extends Application
{
    public static void main(String[] args) throws Exception
    {
        launch(args);
    }

    public void start(Stage stage) throws Exception
    {
        FxmlLoader loader = new FxmlLoader();

        DefaultNavigationManager navigationManager = new DefaultNavigationManager();

        HomeActivity homeActivity = loader.load("/Home.fxml");
        homeActivity.setNavigationManager(navigationManager);

        Page1Activity page1Activity = loader.load("/Page1.fxml");
        page1Activity.setNavigationManager(navigationManager);

        Page2Activity page2Activity = loader.load("/Page2.fxml");
        page2Activity.setNavigationManager(navigationManager);

        Browser browser = new Browser(navigationManager);
        browser.getPlaceResolvers().add(new RegexPlaceResolver("home", homeActivity));
        browser.getPlaceResolvers().add(new RegexPlaceResolver("page1", page1Activity));
        browser.getPlaceResolvers().add(new RegexPlaceResolver("page2", page2Activity));
        navigationManager.goTo(new Place("home"));

        BorderPane root = new BorderPane();
        root.setCenter(browser);
        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.show();
    }
}

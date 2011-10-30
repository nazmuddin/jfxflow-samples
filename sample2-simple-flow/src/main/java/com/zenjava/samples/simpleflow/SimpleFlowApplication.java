package com.zenjava.samples.simpleflow;

import com.zenjava.jfxflow.controller.Browser;
import com.zenjava.jfxflow.controller.FxmlControllerLoader;
import com.zenjava.jfxflow.navigation.DefaultNavigationManager;
import com.zenjava.samples.simpleflow.home.HomeController;
import com.zenjava.samples.simpleflow.home.HomePlace;
import com.zenjava.samples.simpleflow.page1.Page1Controller;
import com.zenjava.samples.simpleflow.page1.Page1Place;
import com.zenjava.samples.simpleflow.page2.Page2Controller;
import com.zenjava.samples.simpleflow.page2.Page2Place;
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
        Browser browser = new Browser("Browser Demo");

        // This extra BorderPane is only needed due to a bug with CSS. Once the bug is fixed
        // we will be able to add the browser directly to the root of the scene
        BorderPane root = new BorderPane();
        root.setCenter(browser);

        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    public void startx(Stage stage) throws Exception
    {
        FxmlControllerLoader loader = new FxmlControllerLoader();

        DefaultNavigationManager navigationManager = new DefaultNavigationManager();

        HomeController homeController = loader.loadController("/Home.fxml");
        homeController.setNavigationManager(navigationManager);

        Page1Controller page1Controller = loader.loadController("/Page1.fxml");
        page1Controller.setNavigationManager(navigationManager);

        Page2Controller page2Controller = loader.loadController("/Page2.fxml");
        page2Controller.setNavigationManager(navigationManager);

        Browser browser = new Browser("Simple Flow", navigationManager, new HomePlace());
        browser.registerController(HomePlace.class, homeController);
        browser.registerController(Page1Place.class, page1Controller);
        browser.registerController(Page2Place.class, page2Controller);

        navigationManager.goTo(new HomePlace());

        BorderPane root = new BorderPane();
        root.setCenter(browser);
        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.show();
    }
}

package com.zenjava.samples.helloworld;

import com.zenjava.jfxflow.controller.FxmlControllerLoader;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloWorldApplication extends Application
{
    public static void main(String[] args) throws Exception
    {
        launch(args);
    }

    public void start(Stage stage) throws Exception
    {
        FxmlControllerLoader loader = new FxmlControllerLoader();
        HelloWorldController controller = loader.loadController("/HelloWorld.fxml");
        Scene scene = new Scene((Parent) controller.getView(), 200, 200);
        stage.setScene(scene);
        stage.show();
    }
}

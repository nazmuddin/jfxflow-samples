package com.zenjava.samples.helloworld;

import com.zenjava.jfxflow.actvity.FxmlLoader;
import javafx.application.Application;
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
        FxmlLoader loader = new FxmlLoader();
        HelloWorldActivity activity = loader.load("/HelloWorld.fxml");
        Scene scene = new Scene(activity.getNode(), 200, 200);
        stage.setScene(scene);
        stage.show();
    }
}

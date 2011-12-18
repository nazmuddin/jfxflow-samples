package com.zenjava.samples.simpleflow;

import com.zenjava.jfxflow.control.Browser;
import com.zenjava.jfxflow.navigation.Place;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JfxFlowShowcaseApplication extends Application
{
    public static void main(String[] args) throws Exception
    {
        launch(args);
    }

    public void start(Stage stage) throws Exception
    {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(JfxFlowShowcaseApplicationFactory.class);
        Browser browser = context.getBean(Browser.class);

        browser.getNavigationManager().goTo(new Place("home"));
        Scene scene = new Scene(browser, 800, 600);
        scene.getStylesheets().add("styles/styles.css");
        stage.setScene(scene);
        stage.show();
    }
}

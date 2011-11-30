package com.zenjava.samples.activityparams;

import com.zenjava.jfxflow.actvity.FxmlLoader;
import com.zenjava.jfxflow.control.Browser;
import com.zenjava.jfxflow.navigation.DefaultNavigationManager;
import com.zenjava.jfxflow.navigation.Place;
import com.zenjava.jfxflow.navigation.RegexPlaceResolver;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ActivityParamsApplication extends Application
{
    public static void main(String[] args) throws Exception
    {
        launch(args);
    }

    public void start(Stage stage) throws Exception
    {
        FxmlLoader loader = new FxmlLoader();
        PersonService personService = new PersonService();
        DefaultNavigationManager navigationManager = new DefaultNavigationManager();
        Browser browser = new Browser(navigationManager);

        ListPersonsActivity listPersonsActivity = loader.load("/ListPersons.fxml");
        listPersonsActivity.setNavigationManager(navigationManager);
        listPersonsActivity.setPersonService(personService);
        browser.getPlaceResolvers().add(new RegexPlaceResolver("person/list", listPersonsActivity));

        ViewPersonActivity viewPersonActivity = loader.load("/ViewPerson.fxml");
        viewPersonActivity.setPersonService(personService);
        browser.getPlaceResolvers().add(new RegexPlaceResolver("person/view", viewPersonActivity));

        navigationManager.goTo(new Place("person/list"));

        BorderPane root = new BorderPane();
        root.setCenter(browser);
        Scene scene = new Scene(root, 800, 600);
        scene.getStylesheets().add("styles.css");
        stage.setScene(scene);
        stage.show();
    }
}

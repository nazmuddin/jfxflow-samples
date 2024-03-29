package com.zenjava.samples.activityparams;

import com.zenjava.jfxflow.actvity.FxmlLoader;
import com.zenjava.jfxflow.control.Browser;
import com.zenjava.jfxflow.navigation.DefaultNavigationManager;
import com.zenjava.jfxflow.navigation.Place;
import com.zenjava.jfxflow.navigation.RegexPlaceResolver;
import javafx.application.Application;
import javafx.scene.Scene;
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
        browser.getPlaceResolvers().add(new RegexPlaceResolver("list-persons", listPersonsActivity));

        ViewPersonActivity viewPersonActivity = loader.load("/ViewPerson.fxml");
        viewPersonActivity.setPersonService(personService);
        browser.getPlaceResolvers().add(new RegexPlaceResolver("view-person", viewPersonActivity));

        navigationManager.goTo(new Place("list-persons"));

        Scene scene = new Scene(browser, 800, 600);
        scene.getStylesheets().add("styles.css");
        stage.setScene(scene);
        stage.show();
    }
}

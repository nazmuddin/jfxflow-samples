package com.zenjava.samples.activityparams;

import com.zenjava.jfxflow.actvity.AbstractActivity;
import com.zenjava.jfxflow.navigation.NavigationManager;
import com.zenjava.jfxflow.navigation.PlaceBuilder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.List;

public class ListPersonsActivity extends AbstractActivity
{
    @FXML private ListView<Person> personsList;

    private NavigationManager navigationManager;
    private PersonService personService;

    public void setNavigationManager(NavigationManager navigationManager)
    {
        this.navigationManager = navigationManager;
    }

    public void setPersonService(PersonService personService)
    {
        this.personService = personService;
    }

    protected void activated()
    {
        List<Person> persons = personService.findAllPersons();
        personsList.getItems().setAll(persons);
    }

    public void viewSelectedPerson(ActionEvent event)
    {
        Person selected = personsList.getSelectionModel().getSelectedItem();
        if (selected != null)
        {
            navigationManager.goTo(new PlaceBuilder("view-person")
                    .parameter("personId", selected.getId())
                    .build()
            );
        }
    }
}

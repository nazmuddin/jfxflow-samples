package com.zenjava.samples.activityparams;

import com.zenjava.jfxflow.actvity.AbstractActivity;
import com.zenjava.jfxflow.navigation.NavigationManager;
import com.zenjava.jfxflow.navigation.Place;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("personId", selected.getId());
            navigationManager.goTo(new Place("person/view", params));
        }
    }
}

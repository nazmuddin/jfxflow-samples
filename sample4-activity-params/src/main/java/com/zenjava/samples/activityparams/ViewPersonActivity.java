package com.zenjava.samples.activityparams;

import com.zenjava.jfxflow.actvity.AbstractActivity;
import com.zenjava.jfxflow.actvity.Param;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ViewPersonActivity extends AbstractActivity
{
    @FXML private Label nameField;
    @FXML private Label profileField;

    @Param private Long personId;

    private PersonService personService;

    public void setPersonService(PersonService personService)
    {
        this.personService = personService;
    }

    protected void activated()
    {
        Person person = personService.getPerson(personId);
        nameField.setText(String.format("%s %s", person.getFirstName(), person.getLastName()));
        profileField.setText(person.getProfile());
    }
}

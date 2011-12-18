package com.zenjava.samples.simpleflow;

import com.zenjava.jfxflow.actvity.AbstractActivity;
import com.zenjava.jfxflow.dialog.Dialog;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;

public class DialogsActivity extends AbstractActivity
{
    public void showSimpleDialog(ActionEvent event)
    {
        Dialog dialog = new Dialog("Simple Dialog");
        dialog.setContent(new Label("You can put your own controls in it"));
        dialog.show(getView().toNode());
    }
}

package com.zenjava.samples.simpleflow;

import com.zenjava.jfxflow.actvity.AbstractActivity;
import com.zenjava.jfxflow.dialog.Dialog;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;

public class DialogsActivity extends AbstractActivity
{
    public void showSimpleDialog(ActionEvent event)
    {
        Dialog dialog = new Dialog("Test Dialog");
        dialog.setContent(new Label("This is a test dialog"));
        dialog.show(getNode());
    }
}

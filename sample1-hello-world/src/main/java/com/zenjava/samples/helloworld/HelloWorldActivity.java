package com.zenjava.samples.helloworld;

import com.zenjava.jfxflow.actvity.AbstractActivity;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloWorldActivity extends AbstractActivity<Parent>
{
    @FXML private TextField nameField;
    @FXML private Label messageLabel;

    public void sayHello(ActionEvent event)
    {
        String name = nameField.getText();
        messageLabel.setText("Hello " + name + ", welcome to JFX Flow!");
    }
}

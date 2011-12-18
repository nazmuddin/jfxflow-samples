package com.zenjava.samples.simpleflow;

import com.zenjava.jfxflow.actvity.AbstractActivity;
import com.zenjava.jfxflow.error.ErrorHandler;
import com.zenjava.jfxflow.worker.BackgroundTask;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ResourceBundle;

public class ThreadingActivity extends AbstractActivity
{
    @FXML Label statusLabel;
    @FXML Label customStatusLabel;
    @FXML Button customTaskButton;
    @FXML ProgressIndicator progressIndicator;

    @Autowired ResourceBundle resources;
    @Autowired ErrorHandler errorHandler;

    protected void activated()
    {
        statusLabel.setText(resources.getString("threading.block.custom.normal"));
        customStatusLabel.setText(resources.getString("threading.block.custom.normal"));
    }

    public void startBackgroundTask(ActionEvent event)
    {
        statusLabel.setText(resources.getString("threading.block.started"));
        executeTask(new BackgroundTask<Void>()
        {
            protected Void call() throws Exception
            {
                Thread.sleep(3000);
                return null;
            }

            protected void onSuccess(Void value)
            {
                statusLabel.setText(resources.getString("threading.block.done"));
            }
        });
    }

    public void startCustomBackgroundTask(ActionEvent event)
    {
        BackgroundTask<Void> task = new BackgroundTask<Void>()
        {
            protected Void call() throws Exception
            {
                updateProgress(0, 100);
                for (int i = 0; i < 100; i++)
                {
                    Thread.sleep(30);
                    updateProgress(i, 100);
                }
                return null;
            }

            protected void onSuccess(Void value)
            {
                customTaskButton.setDisable(false);
                progressIndicator.setVisible(false);
                customStatusLabel.setText(resources.getString("threading.block.custom.done"));
            }
        };

        customStatusLabel.setText(resources.getString("threading.block.custom.started"));
        progressIndicator.progressProperty().bind(task.progressProperty());
        customTaskButton.setDisable(true);
        new Thread(task).start();
        progressIndicator.setVisible(true);
    }

    public void startErrorBackgroundTask(ActionEvent event)
    {
        executeTask(new BackgroundTask<Void>(errorHandler)
        {
            protected Void call() throws Exception
            {
                throw new RuntimeException("An example exception. This error page is stylable via CSS, or you can build your own custom error page");
            }
        });
    }
}

package org.openjfx.graphics.pages;

import events.ChangeFrameEvent;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import org.openjfx.listener.EventListener;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class ProfilePageFXML implements Initializable {
    public Label UsernameLabel;
    private EventListener eventListener;

    public void setListener(EventListener listener) {
        this.eventListener = listener;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void newTweet() {
        eventListener.listen(new ChangeFrameEvent("newTweet"));
    }

    public void personalInfo() {
        eventListener.listen(new ChangeFrameEvent("personalInfo"));
    }

    public void showLists() {
        eventListener.listen(new ChangeFrameEvent("showLists"));
    }

    public void notifications() {
        eventListener.listen(new ChangeFrameEvent("notifications"));
    }

    public void setting() {
        eventListener.listen(new ChangeFrameEvent("setting"));
    }

    public void back() {
        eventListener.listen(new ChangeFrameEvent("mainMenu"));
    }


}

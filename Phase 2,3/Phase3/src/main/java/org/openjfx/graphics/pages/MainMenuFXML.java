package org.openjfx.graphics.pages;

import events.ChangeFrameEvent;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.openjfx.listener.EventListener;

import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuFXML implements Initializable {
    public Label UsernameLabel;
    private EventListener eventListener;
    private String authToken = "";

    public void setListener(EventListener listener) {
        this.eventListener = listener;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void profile() { eventListener.listen(new ChangeFrameEvent("personalPage"));}

    public void messages() {
    }

    public void timeLine() {
        eventListener.listen(new ChangeFrameEvent("timeline"));
    }

    public void explorer() {
        eventListener.listen(new ChangeFrameEvent("explorer"));
    }

    public void logout() {
        eventListener.listen(new ChangeFrameEvent("logout"));
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }
}

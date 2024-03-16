package org.openjfx.graphics.pages;

import events.ChangeFrameEvent;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.openjfx.listener.EventListener;

import java.net.URL;
import java.util.ResourceBundle;

public class OtherProfilePageFXML implements Initializable {
    public Label UsernameLabel;
    public Label LastSeenLabel;
    public Button FollowButton;
    public Button BlockButton;
    public Label WarningLabel;
    EventListener eventListener;

    public void setListener(EventListener listener) {
        this.eventListener = listener;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void follow() {
    }

    public void block() {
    }

    public void back() {eventListener.listen(new ChangeFrameEvent("explorer"));
    }
}

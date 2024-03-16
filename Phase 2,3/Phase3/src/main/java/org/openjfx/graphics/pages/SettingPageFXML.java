package org.openjfx.graphics.pages;

import events.ChangeFrameEvent;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import org.openjfx.listener.EventListener;

import java.net.URL;
import java.util.ResourceBundle;

public class SettingPageFXML implements Initializable {
    public RadioButton ActiveButton;
    public RadioButton DiactiveButton;
    public RadioButton PublicButton;
    public RadioButton PrivateButton;
    private EventListener eventListener;

    public void setListener(EventListener listener) {
        this.eventListener = listener;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void active() {
    }

    public void Diactive() {
    }

    public void Public() {
    }

    public void Private() {
    }

    public void lastSeenEverybody() {
    }

    public void lastSeenFollower() {
    }

    public void lastSeenNobody() {
    }

    public void done() {
    }

    public void back() {eventListener.listen(new ChangeFrameEvent("personalPage"));}

    public void mainMenu() {eventListener.listen(new ChangeFrameEvent("mainMenu"));
    }
}

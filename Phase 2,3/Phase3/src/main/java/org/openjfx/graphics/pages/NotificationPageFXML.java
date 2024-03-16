package org.openjfx.graphics.pages;

import events.ChangeFrameEvent;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.openjfx.listener.EventListener;

public class NotificationPageFXML {
    public TextArea RequestsList;
    public TextField UsernameText;
    private EventListener eventListener;

    public void setListener(EventListener listener) {
        this.eventListener = listener;
    }


    public void accept() {
    }

    public void deny() {
    }

    public void back() {eventListener.listen(new ChangeFrameEvent("personalPage"));}

    public void menu() {eventListener.listen(new ChangeFrameEvent("mainMenu"));}
}

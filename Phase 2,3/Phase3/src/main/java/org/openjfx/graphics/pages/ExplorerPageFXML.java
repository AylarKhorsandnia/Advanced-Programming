package org.openjfx.graphics.pages;

import events.ChangeFrameEvent;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.openjfx.listener.EventListener;

import java.net.URL;

import java.util.ResourceBundle;

public class ExplorerPageFXML implements Initializable {
    public Label WarningLabel;
    EventListener eventListener;

    public void setListener(EventListener listener) {
        this.eventListener = listener;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void search() {
    }


    public void back() {eventListener.listen(new ChangeFrameEvent("mainMenu"));}
}

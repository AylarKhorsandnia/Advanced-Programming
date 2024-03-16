package org.openjfx.graphics.pages;

import events.ChangeFrameEvent;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import org.openjfx.listener.EventListener;

import java.net.URL;
import java.util.ResourceBundle;

public class ListsPageFXML implements Initializable {
    public StackPane StackPaneBlackList;
    public ListView BlockViewList;
    public StackPane StackPaneFollowings;
    public ListView FollowingViewList;
    public StackPane StackPaneFollowers;
    public ListView FollowerViewList;
    public StackPane StackPaneLists;
    private EventListener eventListener;

    public void setListener(EventListener listener) {
        this.eventListener = listener;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void followers() {

    }

    public void followings() {

    }

    public void blackList() {

    }

    public void back() {eventListener.listen(new ChangeFrameEvent("personalPage"));}

    public void menu() {eventListener.listen(new ChangeFrameEvent("mainMenu"));}
}

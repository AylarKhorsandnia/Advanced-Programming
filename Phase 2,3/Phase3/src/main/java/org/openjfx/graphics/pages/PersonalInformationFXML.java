package org.openjfx.graphics.pages;

import events.ChangeFrameEvent;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import org.openjfx.listener.EventListener;

import java.net.URL;
import java.util.ResourceBundle;

public class PersonalInformationFXML implements Initializable {
    public StackPane infoPage;
    public StackPane EditPage;
    public Label usernameLabel1;
    public Label usernameLabel;
    public Label passwordLabel;
    public Label fullNameLabel;
    public Label emailLabel;
    public Label phoneLabel;
    public Label birthdayLabel;
    public Label biographyLabel;
    public TextField usernameTextField;
    public TextField passwordTextField;
    public TextField fullNameTextField;
    public TextField emailTextField;
    public TextField phoneTextField;
    public TextField birthTextField;
    public TextField biographyTextField;
    private EventListener eventListener;

    public void setListener(EventListener listener) {
        this.eventListener = listener;
    }


    public void back() {eventListener.listen(new ChangeFrameEvent("personalPage"));}
    

    public void mainMenu() {eventListener.listen(new ChangeFrameEvent("mainMenu"));}

    public void edit() {eventListener.listen(new ChangeFrameEvent("editInfo"));
    }

    public void doneEdit() {
    }

    public void addProfile() {
    }

    public void logout() {eventListener.listen(new ChangeFrameEvent("logout"));}

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

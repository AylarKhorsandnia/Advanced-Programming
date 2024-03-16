package org.openjfx.graphics.pages;

import events.ChangeFrameEvent;
import events.LoginEvent;
import events.SignUpEvent;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.openjfx.listener.EventListener;

import java.net.URL;
import java.util.ResourceBundle;

public class SignUpPageFXML implements Initializable {
    public TextField usernameField;
    public TextField passwordField;
    public TextField fullNameField;
    public TextField emailField;
    public TextField phoneNumberField;
    public TextField birthdayField;
    public Label warningLabel;
    public Button loginButton;
    private EventListener eventListener;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setListener(EventListener listener) {
        this.eventListener = listener;
    }

    public void back() {
        eventListener.listen(new ChangeFrameEvent("firstPage"));
    }

    public void login() {
        eventListener.listen(new ChangeFrameEvent("loginPage"));
    }

    public void done() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String fullName = fullNameField.getText();
        String email = emailField.getText();
        String phone = phoneNumberField.getText();
        String birthday = birthdayField.getText();
        eventListener.listen(new SignUpEvent(username, password, fullName, email, phone, birthday));

    }
}

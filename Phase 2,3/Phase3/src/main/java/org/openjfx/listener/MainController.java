package org.openjfx.listener;


import events.Event;
import javafx.stage.Stage;
import model.UserModel;
import org.openjfx.graphics.GraphicalAgent;
import responses.Response;
import responses.ResponseVisitor;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class MainController implements ResponseVisitor {
    private final GraphicalAgent graphicalAgent;
    private final EventSender eventSender;
    private final List<Event> events = new LinkedList<>();

    public MainController(EventSender eventSender, Stage stage) throws IOException {
        graphicalAgent = new GraphicalAgent(this::addEvent, eventSender, stage);
        this.eventSender = eventSender;
    }

    public void start() {
        graphicalAgent.initialize();
    }

    private void addEvent(Event event) {
        synchronized (events) {
            Response response = eventSender.send(event);
            if (response != null) {
                response.visit(this);
            }
        }
    }

    @Override
    public void changeFrame(String frame) {
        if(frame.equals("firstPage")){
            graphicalAgent.showFirstPage();
        }
        else if(frame.equals("signUp")){
            graphicalAgent.showSignUpPage();
        }
        else if(frame.equals("loginPage")){
            graphicalAgent.showLoginPage();
        }
        else if(frame.equals("setting")){
            graphicalAgent.showSettingPage();
        }
        else if(frame.equals("mainMenu")){
            graphicalAgent.showMainMenu();
        }
        else if(frame.equals("logout")){
            graphicalAgent.showFirstPage();
        }
        else if(frame.equals("personalPage")){
            graphicalAgent.showUserPersonalPage();
        }
        else if(frame.equals("explorer")){
            graphicalAgent.showExplorerPage();
        }
        else if(frame.equals("newTweet")){
            graphicalAgent.showNewTweetPage();
        }
        else if(frame.equals("notifications")){
            graphicalAgent.showNotificationPage();
        }
        else if(frame.equals("showLists")){
            graphicalAgent.showListsPage();
        }
        else if(frame.equals("personalInfo")){
            graphicalAgent.showPersonalInformationPage();
        }
        else if(frame.equals("editInfo")){
            graphicalAgent.showEditInfoPage();
        }
    }

    @Override
    public void setNameLabel(String authToken, String name) {
        graphicalAgent.mainMenu.getFxmlController().UsernameLabel.setText(name);
    }

    @Override
    public void signUpResponse(String response) {
        graphicalAgent.signUpPage.getFxmlController().warningLabel.setText(response);
        if(response.equals("Done")){
            graphicalAgent.signUpPage.getFxmlController().loginButton.setVisible(true);
        }
    }

    @Override
    public void getUserModel(String authToken, UserModel userModel) {
        graphicalAgent.setUserModel(userModel);
    }


    @Override
    public void loginResponse(String Error, String authToken) {
        if (!authToken.equals("")) {
            graphicalAgent.setAuthToken(authToken);
            graphicalAgent.showMainMenu();
        }
        else graphicalAgent.loginPage.getFxmlController().WarningLabel.setText(Error);
    }

    @Override
    public void newTweet(String authToken) {
        graphicalAgent.showUserPersonalPage();
    }

    @Override
    public void empty() {}
    @Override
    public void exit() {}
    @Override
    public void showMessage(String s) {}
}

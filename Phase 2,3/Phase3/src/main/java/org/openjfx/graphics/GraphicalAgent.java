package org.openjfx.graphics;

import events.GetUserModelEvent;
import events.SetNameLabelEvent;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.UserModel;
import org.openjfx.graphics.pages.*;
import org.openjfx.listener.EventListener;
import org.openjfx.listener.EventSender;

import java.io.IOException;

public class GraphicalAgent {
    private String authToken;

    private final EventListener listener;
    private final EventSender eventSender;
    private final Stage stage;
    private UserModel userModel;
    public final FirstScene firstPage = new FirstScene();
    public final LoginPage loginPage = new LoginPage();
    public final SignUpPage signUpPage = new SignUpPage();
    public final MainMenu mainMenu = new MainMenu();
    private final SettingPage settingPage = new SettingPage();
    private final ExplorerPage explorerPage = new ExplorerPage();
    private final ProfilePage userPersonalPage = new ProfilePage();
    private final NotificationPage notificationPage = new NotificationPage();
    private final ListsPage listsPage = new ListsPage();
    private final PersonalInformationPage personalInformationPage = new PersonalInformationPage();
    private final NewTweetPage newTweetPage = new NewTweetPage();

    public GraphicalAgent(EventListener listener, EventSender eventSender, Stage stage) throws IOException {
        this.stage = stage;
        this.listener = listener;
        this.eventSender = eventSender;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }


    public void initialize() {
        Platform.runLater(
                () -> {
                    firstPage.getFxmlController().setListener(listener);
                    stage.setTitle("OLA!");
                    stage.getIcons().add(new Image("Images/ola.png"));
                    stage.setResizable(false);
                    stage.show();
                    stage.setScene(firstPage.getScene());
                }
        );
    }

    public void showFirstPage() {
        Platform.runLater(
                () -> {
                    firstPage.getFxmlController().setListener(listener);
                    stage.setScene(firstPage.getScene());
                }
        );
    }

    public void showLoginPage() {
        Platform.runLater(
                () -> {
                    loginPage.getFxmlController().setListener(listener);
                    stage.setScene(loginPage.getScene());
                }
        );
    }
    public void showMainMenu(){
        Platform.runLater(
                () -> {
                    mainMenu.getFxmlController().setListener(listener);
                    listener.listen(new GetUserModelEvent(authToken));
                    mainMenu.getFxmlController().setAuthToken(authToken);
                    listener.listen(new SetNameLabelEvent(authToken));
                    stage.setScene(mainMenu.getScene());
                }
        );
    }
    public void showUserPersonalPage(){
        Platform.runLater(
                () -> {
                    userPersonalPage.getFxmlController().setListener(listener);
                    stage.setScene(userPersonalPage.getScene());
                }
        );
    }

    public void showSignUpPage() {
        Platform.runLater(
                () -> {
                    signUpPage.getFxmlController().setListener(listener);
                    stage.setScene(signUpPage.getScene());
                }
        );
    }

    public void showSettingPage() {
        Platform.runLater(
                () -> {
                    settingPage.getFxmlController().setListener(listener);
                    cleanSetting();
                    if(userModel.isActivity()){
                        settingPage.getFxmlController().ActiveButton.setSelected(true);
                    }
                    else settingPage.getFxmlController().DiactiveButton.setSelected(true);
                    if(userModel.isPrivacy()){
                        settingPage.getFxmlController().PrivateButton.setSelected(true);
                    }
                    else settingPage.getFxmlController().PublicButton.setSelected(true);
                    stage.setScene(settingPage.getScene());
                }
        );
    }

    public void cleanSetting(){
        settingPage.getFxmlController().PublicButton.setSelected(false);
        settingPage.getFxmlController().PrivateButton.setSelected(false);
        settingPage.getFxmlController().ActiveButton.setSelected(false);
        settingPage.getFxmlController().DiactiveButton.setSelected(false);

    }


    public void showPersonalInformationPage() {
        Platform.runLater(
                () -> {
                    personalInformationPage.getFxmlController().setListener(listener);
                    setInformation();
                    stage.setScene(personalInformationPage.getScene());
                }
        );
    }

    public void setInformation(){
        personalInformationPage.getFxmlController().usernameLabel1.setText(userModel.getUsername());
        personalInformationPage.getFxmlController().usernameLabel.setText(userModel.getUsername());
        personalInformationPage.getFxmlController().fullNameLabel.setText(userModel.getFullName());
        personalInformationPage.getFxmlController().emailLabel.setText(userModel.getEmailAddress());
        personalInformationPage.getFxmlController().phoneLabel.setText(userModel.getPhoneNumber());
        personalInformationPage.getFxmlController().birthdayLabel.setText(userModel.getBirthday());
        personalInformationPage.getFxmlController().biographyLabel.setText(userModel.getBiography());


    }

    public void showEditInfoPage(){
        personalInformationPage.getFxmlController().setListener(listener);
        personalInformationPage.getFxmlController().infoPage.setVisible(false);
        personalInformationPage.getFxmlController().EditPage.setVisible(true);
        personalInformationPage.getFxmlController().usernameTextField.setText(userModel.getUsername());
        personalInformationPage.getFxmlController().fullNameTextField.setText(userModel.getFullName());
        personalInformationPage.getFxmlController().emailTextField.setText(userModel.getEmailAddress());
        personalInformationPage.getFxmlController().phoneTextField.setText(userModel.getPhoneNumber());
        personalInformationPage.getFxmlController().birthTextField.setText(userModel.getBirthday());
        personalInformationPage.getFxmlController().biographyTextField.setText(userModel.getBiography());

    }

    public void showExplorerPage() {
        Platform.runLater(
                () -> {
                    explorerPage.getFxmlController().setListener(listener);
                    stage.setScene(explorerPage.getScene());
                }
        );
    }

    public void showNewTweetPage() {
        Platform.runLater(
                () -> {
                    newTweetPage.getFxmlController().setListener(listener);
//                    newTweetPage.getFxmlController().nameLabel.setText();
                    stage.setScene(newTweetPage.getScene());
                }
        );
    }
    public void showNotificationPage() {
        Platform.runLater(
                () -> {
                    notificationPage.getFxmlController().setListener(listener);
                    stage.setScene(notificationPage.getScene());
                }
        );
    }
    public void showListsPage() {
        Platform.runLater(
                () -> {
                    listsPage.getFxmlController().setListener(listener);
                    stage.setScene(listsPage.getScene());
                }
        );
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }
}

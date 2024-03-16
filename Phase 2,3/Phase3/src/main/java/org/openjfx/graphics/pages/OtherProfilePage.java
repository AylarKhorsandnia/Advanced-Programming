package org.openjfx.graphics.pages;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import org.openjfx.graphics.GraphicalAgent;

import java.io.IOException;

public class OtherProfilePage {
    private final Scene scene;
    private final FXMLLoader fxmlLoader;

    public OtherProfilePage() throws IOException {
        this.fxmlLoader = new FXMLLoader(GraphicalAgent.class.getResource("other_profile_page.fxml"));
        Parent root = fxmlLoader.load();
        this.scene = new Scene(root);
    }

    public Scene getScene() {
        return scene;
    }

    public OtherProfilePageFXML getFxmlController() {
        return fxmlLoader.getController();
    }




}

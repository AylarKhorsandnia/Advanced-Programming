package org.openjfx.graphics.pages;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import org.openjfx.graphics.GraphicalAgent;

import java.io.IOException;

public class FirstScene {
    private final Scene scene;
    private final FXMLLoader fxmlLoader;

    public FirstScene() throws IOException {
        this.fxmlLoader = new FXMLLoader(GraphicalAgent.class.getResource("first_scene.fxml"));
        Parent root = fxmlLoader.load();
        this.scene = new Scene(root);
    }

    public Scene getScene() {
        return scene;
    }

    public FirstSceneFXML getFxmlController() {
        return fxmlLoader.getController();
    }
}

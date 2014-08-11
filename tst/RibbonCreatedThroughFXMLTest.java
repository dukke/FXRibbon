package com.pixelduke.javafx.ribbon.tests;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by pedro_000 on 1/22/14.
 */
public class RibbonCreatedThroughFXMLTest extends Application {
    static final String RESOURCE = "RibbonFXML.fxml";

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(RESOURCE));
//        root.getStylesheets().add(getClass().getResource(STYLE_SHEET).toExternalForm());
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

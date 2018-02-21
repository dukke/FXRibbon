package com.pixelduke.control;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

/**
 * Created by pedro_000 on 1/22/14.
 */
public class RibbonCreatedThroughFXMLTest extends Application {
    private static final String RESOURCE = "RibbonFXML.fxml";

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        URL resource = RibbonCreatedThroughFXMLTest.class.getResource(RESOURCE);
        Parent root = FXMLLoader.load(resource);
        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}

package com.pixelduke.control;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

/**
 * Created by pedro_000 on 11/20/2014.
 */
public class RibbonWithMultipleButtonsVerticallyTest extends Application {

        static final String RESOURCE = "java/com/pixelduke/control/RibbonWithMultipleButtonsVertically.fxml";

        @Override
        public void start(Stage primaryStage) throws Exception
        {
            URL resource = getClass().getResource(RESOURCE);
            Parent root = FXMLLoader.load(resource);
//        root.getStylesheets().add(getClass().getResource(STYLE_SHEET).toExternalForm());
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        }

    public static void main(String[] args)
    {
        launch(args);
    }
}



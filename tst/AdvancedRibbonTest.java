package com.pixelduke.javafx.ribbon.tests;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.scenicview.ScenicView;

import java.net.URL;

/**
 * Created by pedro_000 on 1/6/2015.
 */
public class AdvancedRibbonTest extends Application {
    static final String RESOURCE = "AdvancedRibbonFXML.fxml";
    static final String STYLE_SHEET = "../resource/fxribbon.css";

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        URL resource = getClass().getResource(RESOURCE);
        Parent root = FXMLLoader.load(resource);
        root.getStylesheets().add(getClass().getResource(STYLE_SHEET).toExternalForm());
        Scene scene = new Scene(root);

//        ScenicView.show(scene);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
package com.pixelduke.control;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import jfxtras.styles.jmetro8.JMetro;

import java.net.URL;

public class ChangeStyleRibbonInCSSFileSample extends Application {
    private static final String RESOURCE = "CompleteRibbonFXML.fxml";
    private static final String CSS_FILE = "ribbon_sample.css";

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        URL resource = ChangeStyleRibbonInCSSFileSample.class.getResource(RESOURCE);
        Parent root = FXMLLoader.load(resource);

        Scene scene = new Scene(root);

//        ScenicView.show(scene);
        new JMetro(JMetro.Style.LIGHT).applyTheme(scene);

        scene.getStylesheets().add(ChangeStyleRibbonInCSSFileSample.class.getResource(CSS_FILE).toExternalForm());

        primaryStage.setMaximized(true);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}

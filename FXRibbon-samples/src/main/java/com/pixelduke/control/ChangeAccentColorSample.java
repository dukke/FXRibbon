package com.pixelduke.control;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import jfxtras.styles.jmetro8.JMetro;

import java.net.URL;

public class ChangeAccentColorSample extends Application {
    private static final String RESOURCE = "CompleteRibbonFXML.fxml";

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        URL resource = ChangeAccentColorSample.class.getResource(RESOURCE);
        Parent root = FXMLLoader.load(resource);

        Ribbon ribbon = (Ribbon) root.lookup(".ribbon");
        ribbon.setStyle("ACCENT_COLOR: #10893e");

        Scene scene = new Scene(root);

//        ScenicView.show(scene);
        new JMetro(JMetro.Style.LIGHT).applyTheme(scene);


        primaryStage.setMaximized(true);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}


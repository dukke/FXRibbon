package com.pixelduke.javafx.ribbon.tests;

import com.pixelduke.javafx.ribbon.Ribbon;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Created by pedro_000 on 1/20/14.
 */
public class RibbonWithEmptyTabsTest extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane rootNode = new BorderPane();
        Ribbon ribbon = new Ribbon();
        ribbon.getTabTitles().addAll("Home", "Scrape", "Filter", "Options", "Help");
        rootNode.setCenter(ribbon);

        Scene scene = new Scene(rootNode);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

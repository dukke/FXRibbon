package com.pixelduke.javafx.ribbon.tests;

import com.pixelduke.javafx.ribbon.Column;
import com.pixelduke.javafx.ribbon.Ribbon;
import com.pixelduke.javafx.ribbon.RibbonGroup;
import com.pixelduke.javafx.ribbon.RibbonTab;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Created by pedro_000 on 1/21/14.
 */
public class RibbonWithGroupTest extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane rootNode = new BorderPane();
        Ribbon ribbon = new Ribbon();
        RibbonTab ribbonTab = new RibbonTab("Test");
        RibbonGroup ribbonGroup = new RibbonGroup();
        rootNode.setCenter(ribbon);

        Image storeImage = new Image(getClass().getResourceAsStream("store.png"));
        Button storeButton = new Button("Store", new ImageView(storeImage));
        storeButton.setContentDisplay(ContentDisplay.TOP);
        ribbonGroup.getNodes().add(storeButton);

        ribbonTab.getRibbonGroups().add(ribbonGroup);
        ribbon.getTabs().add(ribbonTab);

        Scene scene = new Scene(rootNode);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

package com.pixelduke.javafx.ribbon.tests;

import com.pixelduke.javafx.ribbon.Column;
import com.pixelduke.javafx.ribbon.RibbonGroup;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Created by pedro_000 on 1/20/14.
 */
public class RibbonGroupWithButtonTest extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane rootNode = new BorderPane();
        RibbonGroup ribbonGroup = new RibbonGroup();
        rootNode.setCenter(ribbonGroup);

        Image storeImage = new Image(getClass().getResourceAsStream("store.png"));
        Button storeButton = new Button("Store", new ImageView(storeImage));
        storeButton.setContentDisplay(ContentDisplay.TOP);
        ribbonGroup.getNodes().add(storeButton);

        Scene scene = new Scene(rootNode);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

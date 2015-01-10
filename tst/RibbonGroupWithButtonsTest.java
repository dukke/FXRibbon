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
 * Created by pedro_000 on 1/21/14.
 */
public class RibbonGroupWithButtonsTest extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane rootNode = new BorderPane();
        RibbonGroup ribbonGroup = new RibbonGroup();
        rootNode.setCenter(ribbonGroup);

        Image iconImage = new Image(getClass().getResourceAsStream("play.png"));
        Button iconButton = new Button("Play", new ImageView(iconImage));
        iconButton.setContentDisplay(ContentDisplay.LEFT);
        ribbonGroup.getNodes().add(iconButton);


        iconImage = new Image(getClass().getResourceAsStream("stop.png"));
        iconButton = new Button("Stop", new ImageView(iconImage));
        iconButton.setContentDisplay(ContentDisplay.LEFT);
        ribbonGroup.getNodes().add(iconButton);

        iconImage = new Image(getClass().getResourceAsStream("pause.png"));
        iconButton = new Button("Pause", new ImageView(iconImage));
        iconButton.setContentDisplay(ContentDisplay.LEFT);
        ribbonGroup.getNodes().add(iconButton);

        iconImage = new Image(getClass().getResourceAsStream("fastForward.png"));
        iconButton = new Button("Next", new ImageView(iconImage));
        iconButton.setContentDisplay(ContentDisplay.LEFT);
        ribbonGroup.getNodes().add(iconButton);

        Scene scene = new Scene(rootNode);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

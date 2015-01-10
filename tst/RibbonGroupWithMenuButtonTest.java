package com.pixelduke.javafx.ribbon.tests;

import com.pixelduke.javafx.ribbon.Column;
import com.pixelduke.javafx.ribbon.RibbonGroup;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Created by pedro_000 on 1/21/14.
 */
public class RibbonGroupWithMenuButtonTest extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane rootNode = new BorderPane();
        RibbonGroup ribbonGroup = new RibbonGroup();
        rootNode.setCenter(ribbonGroup);

        MenuButton number = new MenuButton("Number");
        Image iconImage = new Image(getClass().getResourceAsStream("number.png"));
        number.setGraphic(new ImageView(iconImage));

        number.getItems().addAll(new MenuItem("test1"), new MenuItem("test2"), new MenuItem("test3"), new MenuItem("test4"));
        ribbonGroup.getNodes().addAll(number);

        Scene scene = new Scene(rootNode);
//        ScenicView.show(scene);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

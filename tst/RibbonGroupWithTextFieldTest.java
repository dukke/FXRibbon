package com.pixelduke.javafx.ribbon.tests;

import com.pixelduke.javafx.ribbon.Column;
import com.pixelduke.javafx.ribbon.RibbonGroup;
import com.pixelduke.javafx.ribbon.RibbonTextField;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Created by pedro_000 on 1/21/14.
 */
public class RibbonGroupWithTextFieldTest extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane rootNode = new BorderPane();
        RibbonGroup ribbonGroup = new RibbonGroup();
        rootNode.setCenter(ribbonGroup);

        ribbonGroup.getNodes().add(new RibbonTextField("Fake IP Address:"));
        ribbonGroup.getNodes().add(new RibbonTextField("Timeout(seconds):"));

        Scene scene = new Scene(rootNode);
//        ScenicView.show(scene);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


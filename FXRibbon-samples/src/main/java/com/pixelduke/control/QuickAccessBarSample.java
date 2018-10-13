package com.pixelduke.control;

import com.pixelduke.control.ribbon.QuickAccessBar;
import com.pixelduke.control.ribbon.RibbonGroup;
import com.pixelduke.control.ribbon.RibbonTab;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class QuickAccessBarSample extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane rootNode = new BorderPane();
        Ribbon ribbon = new Ribbon();
        RibbonTab ribbonTab = new RibbonTab("Notes");
        RibbonGroup ribbonGroup = new RibbonGroup();

        rootNode.setTop(ribbon);

        Image image = new Image(QuickAccessBarSample.class.getResource("icons8_Bold_32px.png").toExternalForm());
        ImageView imageView = new ImageView(image);
        Button iconButton = new Button("Bold", imageView);
        iconButton.setContentDisplay(ContentDisplay.TOP);
        ribbonGroup.getNodes().add(iconButton);

        image = new Image(QuickAccessBarSample.class.getResource("icons8_Italic_32px.png").toExternalForm());
        imageView = new ImageView(image);
        iconButton = new Button("Italic", imageView);
        iconButton.setContentDisplay(ContentDisplay.TOP);
        ribbonGroup.getNodes().add(iconButton);

        image = new Image(QuickAccessBarSample.class.getResource("icons8_Underline_32px.png").toExternalForm());
        imageView = new ImageView(image);
        iconButton = new Button("Underline", imageView);
        iconButton.setContentDisplay(ContentDisplay.TOP);
        iconButton.setMinSize(Button.USE_PREF_SIZE, Button.USE_PREF_SIZE);
        ribbonGroup.getNodes().add(iconButton);
        ribbonTab.getRibbonGroups().add(ribbonGroup);

        ribbon.getTabs().add(ribbonTab);

        QuickAccessBar quickAccessBar = new QuickAccessBar();
        // Save
        Button saveButton = new Button();
        image = new Image(QuickAccessBarSample.class.getResource("icons8_Save_16px.png").toExternalForm());
        imageView = new ImageView(image);
        saveButton.setGraphic(imageView);

        // Undo
        Button undoButton = new Button();
        image = new Image(QuickAccessBarSample.class.getResource("icons8_Undo_16px.png").toExternalForm());
        imageView = new ImageView(image);
        undoButton.setGraphic(imageView);

        // Redo
        Button redoButton = new Button();
        image = new Image(QuickAccessBarSample.class.getResource("icons8_Redo_16px.png").toExternalForm());
        imageView = new ImageView(image);
        redoButton.setGraphic(imageView);

        quickAccessBar.getButtons().addAll(saveButton, undoButton, redoButton);

        ribbon.setQuickAccessBar(quickAccessBar);

        Scene scene = new Scene(rootNode);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

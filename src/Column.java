package com.pixelduke.javafx.ribbon;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

/**
 * Created by pedro_000 on 11/20/2014.
 */
public class Column extends VBox{
    public final static int SPACING = 6;
    public final static int PADDING = 16;
    public final static String DEFAULT_STYLE_CLASS = "column";

    public Column()
    {
        setSpacing(SPACING);
        setPadding(new Insets(PADDING, 0, PADDING, 0));

        getStyleClass().setAll(DEFAULT_STYLE_CLASS);
    }

}

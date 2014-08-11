package com.pixelduke.javafx.ribbon;

import com.pixelduke.javafx.ribbon.skin.QuickAccessBarSkin;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Skin;

/**
 * Created by pedro_000 on 2/19/14.
 */
public class QuickAccessBar extends Control {
    public final static String DEFAULT_STYLE_CLASS = "quick-access-bar";

    ObservableList<Button> buttons;
    ObservableList<Button> rightButtons;

    public QuickAccessBar()
    {
        buttons = FXCollections.observableArrayList();
        rightButtons = FXCollections.observableArrayList();

        getStyleClass().setAll(DEFAULT_STYLE_CLASS);
    }

    public ObservableList<Button> getButtons(){
        return buttons;
    }

    public ObservableList<Button> getRightButtons()
    {
        return rightButtons;
    }

    @Override
    protected Skin<?> createDefaultSkin() {
        return new QuickAccessBarSkin(this);
    }
}

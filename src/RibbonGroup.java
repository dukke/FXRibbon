package com.pixelduke.javafx.ribbon;

import com.pixelduke.javafx.ribbon.skin.RibbonGroupSkin;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Control;
import javafx.scene.control.Skin;

/**
 * Created by pedro_000 on 1/20/14.
 */
public class RibbonGroup extends Control{
    public final static String DEFAULT_STYLE_CLASS = "ribbon-group";

    private ObservableList<Node> nodes;

    public RibbonGroup()
    {
        nodes = FXCollections.observableArrayList();

        getStyleClass().setAll(DEFAULT_STYLE_CLASS);
    }

    public ObservableList<Node> getNodes()
    {
        return nodes;
    }

    @Override
    protected Skin<?> createDefaultSkin() {
        return new RibbonGroupSkin(this);
    }
}

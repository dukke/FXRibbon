package com.pixelduke.javafx.ribbon;

import com.pixelduke.javafx.ribbon.skin.RibbonGroupSkin;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Control;
import javafx.scene.control.Labeled;
import javafx.scene.control.Skin;

/**
 * Created by pedro_000 on 1/20/14.
 */
public class RibbonGroup extends Labeled {
    public final static String DEFAULT_STYLE_CLASS = "ribbon-group";

    private ObservableList<Node> nodes;
    private SimpleStringProperty title;

    public RibbonGroup()
    {
        nodes = FXCollections.observableArrayList();
        title = new SimpleStringProperty("");

        getStyleClass().setAll(DEFAULT_STYLE_CLASS);
    }

    public ObservableList<Node> getNodes()
    {
        return nodes;
    }

    public void setTitle(String title)
    {
        this.title.set(title);
    }

    public String getTitle()
    {
        return title.get();
    }

    public StringProperty titleProperty()
    {
        return title;
    }

    @Override
    protected Skin<?> createDefaultSkin() {
        return new RibbonGroupSkin(this);
    }
}

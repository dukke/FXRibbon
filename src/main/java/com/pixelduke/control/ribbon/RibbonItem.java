package com.pixelduke.control.ribbon;

import impl.com.pixelduke.skin.ribbon.RibbonItemSkin;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Node;
import javafx.scene.control.Control;
import javafx.scene.control.Skin;

/**
 * Created by pedro_000 on 1/19/2015.
 */
public class RibbonItem extends Control {
    private static String DEFAULT_STYLE_CLASS = "ribbon-item";

    private ObjectProperty<Node> graphic;
    private StringProperty label;
    private ObjectProperty<Node> item;

    public RibbonItem()
    {
        graphic = new SimpleObjectProperty<>();
        label = new SimpleStringProperty();
        item = new SimpleObjectProperty<>();

        getStyleClass().setAll(DEFAULT_STYLE_CLASS);
    }



    public Node getGraphic()
    {
        return graphic.get();
    }

    public void setGraphic(Node graphic)
    {
        this.graphic.set(graphic);
    }

    public ObjectProperty graphicProperty()
    {
        return graphic;
    }

    public String getLabel()
    {
        return label.get();
    }

    public void setLabel(String label)
    {
        this.label.set(label);
    }

    public StringProperty labelPropery()
    {
        return label;
    }

    public void setItem(Node item)
    {
        this.item.set(item);
    }

    public Node getItem()
    {
        return item.get();
    }

    public ObjectProperty itemProperty()
    {
        return item;
    }

    @Override
    protected Skin<?> createDefaultSkin() {
        return new RibbonItemSkin(this);
    }
}

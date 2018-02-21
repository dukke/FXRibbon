package com.pixelduke.control.ribbon;

import com.pixelduke.control.Ribbon;
import impl.com.pixelduke.skin.ribbon.GallerySkin;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Control;
import javafx.scene.control.Skin;

/**
 * Created by pedro_000 on 1/13/2015.
 */
public class Gallery extends Control {
    public static String DEFAULT_STYLE_CLASS = "gallery";

    private ObservableList<GalleryItem> items;
    private ObjectProperty<GalleryItem> selectedItem;

    private IntegerProperty numOfVisibleItems = new SimpleIntegerProperty(1);

    public Gallery()
    {
        items = FXCollections.observableArrayList();
        selectedItem = new SimpleObjectProperty<>();

        getStyleClass().setAll(DEFAULT_STYLE_CLASS);
    }

    public ObservableList<GalleryItem> getItems()
    {
        return items;
    }

    public void setNumOfVisibleItems(int num){
        numOfVisibleItems.set(num);
    }

    public int getNumOfVisibleItems()
    {
        return numOfVisibleItems.get();
    }

    public IntegerProperty numOfVisibleItemsProperty()
    {
        return numOfVisibleItems;
    }

    public void setSelectedItem(GalleryItem item)
    {
        selectedItem.set(item);
    }

    public GalleryItem getSelectedItem()
    {
        return selectedItem.get();
    }

    public ObjectProperty<GalleryItem> selectedItemProperty()
    {
        return selectedItem;
    }

    @Override
    protected Skin<?> createDefaultSkin() {
        return new GallerySkin(this);
    }

    @Override
    public String getUserAgentStylesheet() {
        return Ribbon.class.getResource("fxribbon.css").toExternalForm();
    }
}


/*
 *  Copyright (c) 2016, 2018 Pixel Duke (Pedro Duque Vieira - www.pixelduke.com)
 *  All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *    * Redistributions of source code must retain the above copyright
 *  notice, this list of conditions and the following disclaimer.
 *    * Redistributions in binary form must reproduce the above copyright
 *  notice, this list of conditions and the following disclaimer in the
 *  documentation and/or other materials provided with the distribution.
 *    * Neither the name of Pixel Duke, any associated website, nor the
 *  names of its contributors may be used to endorse or promote products
 *  derived from this software without specific prior written permission.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 *  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 *  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 *  DISCLAIMED. IN NO EVENT SHALL PIXEL DUKE BE LIABLE FOR ANY
 *  DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 *  (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 *  LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 *  ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *  (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.pixelduke.control.ribbon;

import com.pixelduke.control.Ribbon;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Popup;

import java.util.HashMap;

public class GalleryPopup extends Popup {
    private ObservableList<GalleryItem> galleryItems;

    private VBox outerContainer;

    private ToggleGroup buttonGroup;

    private HashMap<String, FlowPane> categoryContainer;

    private Gallery gallery;

    private HashMap<GalleryItem, ToggleButton> galleryItemButton;

    public GalleryPopup(Gallery gallery)
    {
        this.gallery = gallery;

        buttonGroup = new ToggleGroup();
        galleryItemButton = new HashMap<>();

        outerContainer = new VBox();
        outerContainer.getStylesheets().add(Ribbon.class.getResource("fxribbon.css").toExternalForm());

        categoryContainer = new HashMap<>();

        galleryItems = gallery.getItems();

        setAutoHide(true);
        setHideOnEscape(true);
        setAutoFix(true);

        galleryItems.addListener((ListChangeListener<GalleryItem>) c -> updatePopup());

        getContent().add(outerContainer);

        outerContainer.getStyleClass().add("gallery-popup-container");

        updatePopup();

        gallery.selectedItemProperty().addListener((observable, oldValue, newValue) -> selectedItemChanged());
    }

    private void selectedItemChanged() {
        ToggleButton toggleButton = galleryItemButton.get(gallery.getSelectedItem());
        toggleButton.setSelected(true);
    }

    private void updatePopup() {
        for (GalleryItem item : galleryItems)
        {
            if (categoryContainer.get(item.getCategory()) == null) {
                Label categoryTitle = new Label(item.getCategory());
                categoryTitle.getStyleClass().add("category-title");

                BorderPane borderPane = new BorderPane();
                borderPane.getStyleClass().add("category-title-background");
                borderPane.setLeft(categoryTitle);

                outerContainer.getChildren().add(borderPane);
                FlowPane flowPane = new FlowPane();
                outerContainer.getChildren().add(flowPane);

                categoryContainer.put(item.getCategory(), flowPane);
                flowPane.getChildren().add(createPopupItem(item));
            } else
            {
                FlowPane flowPane = categoryContainer.get(item.getCategory());
                flowPane.getChildren().add(createPopupItem(item));
            }
        }
    }

    public ObservableList<GalleryItem> getGalleryItems()
    {
        return galleryItems;
    }

    private Node createPopupItem(final GalleryItem item)
    {
        SnapshotParameters snapshotParameters = new SnapshotParameters();
        snapshotParameters.setFill(Color.TRANSPARENT);

        Image image = item.getGraphic().snapshot(snapshotParameters, null);
        ToggleButton button = new ToggleButton(item.getName());
        button.setContentDisplay(ContentDisplay.TOP);
        button.setGraphic(new ImageView(image));

        button.setOnAction(event -> gallery.setSelectedItem(item));

        buttonGroup.getToggles().add(button);

        galleryItemButton.put(item, button);

        return button;
    }
}

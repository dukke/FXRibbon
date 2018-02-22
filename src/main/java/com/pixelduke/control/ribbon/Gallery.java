
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
import impl.com.pixelduke.skin.ribbon.GallerySkin;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Control;
import javafx.scene.control.Skin;

public class Gallery extends Control {
    private final static String DEFAULT_STYLE_CLASS = "gallery";

    private final ObservableList<GalleryItem> items;
    private final ObjectProperty<GalleryItem> selectedItem;

    private final IntegerProperty numOfVisibleItems = new SimpleIntegerProperty(1);

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

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

import impl.com.pixelduke.skin.ribbon.RibbonItemSkin;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Node;
import javafx.scene.control.Control;
import javafx.scene.control.Skin;

public class RibbonItem extends Control {
    private final static String DEFAULT_STYLE_CLASS = "ribbon-item";

    public RibbonItem()
    {
        graphic = new SimpleObjectProperty<>();
        label = new SimpleStringProperty();
        item = new SimpleObjectProperty<>();

        getStyleClass().setAll(DEFAULT_STYLE_CLASS);
    }

    private final ObjectProperty<Node> graphic;
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


    private final StringProperty label;
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


    private final ObjectProperty<Node> item;
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

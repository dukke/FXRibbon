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

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.control.Tab;
import javafx.scene.layout.HBox;

import java.util.List;

public class RibbonTab extends Tab {
//    public static final int CONTENT_HEIGHT = 70;
    private static final String DEFAULT_STYLE_CLASS = "ribbon-tab";

    private HBox content;

    private String contextualColor;

    public RibbonTab()
    {
        init();
    }

    public RibbonTab(String title)
    {
        super(title);
        init();
    }

    private void init() {
        content = new HBox();
//        content.setMinHeight(CONTENT_HEIGHT);
        this.setContent(content);

        setClosable(false);

        ribbonGroups.addListener(this::groupsChanged);
        content.getStyleClass().setAll(DEFAULT_STYLE_CLASS, "tab");
        getStyleClass().addListener((ListChangeListener<String>) c -> {
            while(c.next())
            {
                if (c.wasAdded())
                {
                    for (String style : c.getAddedSubList())
                    {
                        content.getStyleClass().add(style);
                    }
                }
            }
        });

    }

    public void setContextualColor(String color)
    {
        contextualColor = color;
        getStyleClass().add(color);
    }

    public String getContextualColor()
    {
        return contextualColor;
    }

    private void groupsChanged(ListChangeListener.Change<? extends RibbonGroup> changed) {
        while(changed.next())
        {
            if (changed.wasAdded())
            {
                updateAddedGroups(changed.getAddedSubList());
            }
            if(changed.wasRemoved())
            {
                for (RibbonGroup group : changed.getRemoved())
                {
                    int groupIndex = content.getChildren().indexOf(group);
                    if (groupIndex != 0)
                        content.getChildren().remove(groupIndex - 1); // Remove separator
                    content.getChildren().remove(group);

                }

            }
        }
    }

    private void updateAddedGroups(List<? extends RibbonGroup> addedSubList) {
        for (RibbonGroup group : addedSubList)
        {
            content.getChildren().add(group);
        }
    }


    private final ObservableList<RibbonGroup> ribbonGroups = FXCollections.observableArrayList();

    public ObservableList<RibbonGroup> getRibbonGroups()
    {
        return ribbonGroups;
    }
}

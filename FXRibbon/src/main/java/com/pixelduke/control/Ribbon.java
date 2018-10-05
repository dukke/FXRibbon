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

package com.pixelduke.control;

import com.pixelduke.control.ribbon.QuickAccessBar;
import com.pixelduke.control.ribbon.RibbonTab;
import impl.com.pixelduke.skin.RibbonSkin;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.control.Control;
import javafx.scene.control.Skin;

import java.util.Collection;
import java.util.HashMap;

public class Ribbon extends Control{
    private final static String DEFAULT_STYLE_CLASS = "ribbon";

    private final ObservableList<RibbonTab> tabs;

    private QuickAccessBar quickAccessBar;

    public Ribbon()
    {
        quickAccessBar = new QuickAccessBar();

        tabs = FXCollections.observableArrayList();

        getStyleClass().setAll(DEFAULT_STYLE_CLASS);
    }

    public ObservableList<RibbonTab> getTabs(){
        return tabs;
    }


    /***************************************************************************
     *                                                                         *
     * Properties                                                              *
     *                                                                         *
     **************************************************************************/

    /** Selected Ribbon Tab **/
    private final SimpleObjectProperty<RibbonTab> selectedRibbonTab = new SimpleObjectProperty<>();

    public SimpleObjectProperty selectedRibbonTabProperty()
    {
        return selectedRibbonTab;
    }
    public RibbonTab getSelectedRibbonTab()
    {
        return selectedRibbonTab.get();
    }
    public void setSelectedRibbonTab(RibbonTab ribbonTab)
    {
        selectedRibbonTab.set(ribbonTab);
    }


    public QuickAccessBar getQuickAccessBar()
    {
        return quickAccessBar;
    }
    public void setQuickAccessBar(QuickAccessBar qAccessBar)
    {
        quickAccessBar = qAccessBar;
    }


    @Override
    public String getUserAgentStylesheet() {
        return Ribbon.class.getResource("fxribbon.css").toExternalForm();
    }

    @Override
    protected Skin<?> createDefaultSkin() {
        return new RibbonSkin(this);
    }

}

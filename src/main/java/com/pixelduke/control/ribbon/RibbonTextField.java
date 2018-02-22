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

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class RibbonTextField extends VBox {
    private static final String DEFAULT_STYLE_CLASS = "ribbon-text-field";
    private TextField textField;
    private Label label;

    public RibbonTextField()
    {
        init();
    }

    public RibbonTextField(String label)
    {
        init();
        setLabel(label);
    }

    private void init() {
        textField = new TextField();
        getChildren().add(textField);
        setMaxHeight(Region.USE_PREF_SIZE); // It also centers the textfield as a side effect
        getStyleClass().setAll(DEFAULT_STYLE_CLASS);
//        setSpacing(2);
    }

    public void setLabel(String label){
        if (this.label == null)
        {
            this.label = new Label();
            getChildren().add(0, this.label);
        }
        this.label.setText(label);
    }

    public String getLabel(){
        return this.label.getText();
    }

    public void setText(String text)
    {
        textField.setText(text);
    }

    public String getText()
    {
        return textField.getText();
    }

    public void setPromptText(String promptText)
    {
        textField.setPromptText(promptText);
    }

    public String getPromptText()
    {
        return textField.getPromptText();
    }
}

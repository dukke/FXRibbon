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

import javafx.beans.property.*;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class Icon extends Label{
	private final static String DEFAULT_ICON_SIZE = "3em";

	static {
		Font.loadFont(Icon.class.getResource("fontawesome-webfont.ttf").toExternalForm(), 10);
	}

	public Icon() {
		setSize(DEFAULT_ICON_SIZE);
	}

	public Icon(AwesomeIcon icon){
		this();
		setValue(icon);
	}

	public Icon(AwesomeIcon icon, String size){
		this(icon);
		setSize(size);
	}

	private final ObjectProperty<AwesomeIcon> valueProperty = new SimpleObjectProperty<AwesomeIcon>()
	{
		@Override
		protected void invalidated() {
			setText(get().toString());
		}
	};

	public AwesomeIcon getValue() {
		return valueProperty.get();
	}

	public void setValue(final AwesomeIcon value) {
		valueProperty.set(value);
	}

	public ObjectProperty<AwesomeIcon> valueProperty() {
		return valueProperty;
	}

	private final StringProperty sizeProperty = new SimpleStringProperty() {
		@Override
		protected void invalidated() {
			setStyle("-fx-font-family: FontAwesome; -fx-font-size: " + get() + ";");
		}
	};

	public String getSize() {
		return sizeProperty().get();
	}

	public void setSize(final String size) {
		sizeProperty.set(size);
	}

	public StringProperty sizeProperty() {
		return sizeProperty;
	}
}

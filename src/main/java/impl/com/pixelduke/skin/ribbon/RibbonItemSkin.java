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

package impl.com.pixelduke.skin.ribbon;

import com.pixelduke.control.ribbon.RibbonItem;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.SkinBase;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

public class RibbonItemSkin extends SkinBase<RibbonItem> {

    private final BorderPane borderPane;
    private final Label label;

    /**
     * Constructor for all SkinBase instances.
     *
     * @param control The control for which this Skin should attach to.
     */
    public RibbonItemSkin(RibbonItem control) {
        super(control);

        borderPane = new BorderPane();
        label = new Label();

        control.graphicProperty().addListener((observable, oldValue, newValue) -> graphicChanged());
        control.labelPropery().addListener((observable, oldValue, newValue) -> labelChanged());
        control.itemProperty().addListener((observable, oldValue, newValue) -> itemChanged());

        if (control.getLabel() != null || control.getGraphic() != null)
        {
            if (control.getLabel() != null)
                label.setText(control.getLabel());
            if (control.getGraphic() != null)
                label.setGraphic(control.getGraphic());
            addLabel();
        }

        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(control.getItem());
        borderPane.setRight(stackPane);

        getChildren().add(borderPane);
    }

    private void itemChanged() {
        Node item = getSkinnable().getItem();

        if (item != null)
        {
            StackPane stackPane = new StackPane();
            stackPane.getChildren().add(item);
            borderPane.setRight(stackPane);
        }
    }

    private void labelChanged() {
        String labelText = getSkinnable().getLabel();

        if (labelText != null)
        {
            label.setText(labelText);
            addLabel();
        }
    }


    private void graphicChanged() {
        Node graphic = getSkinnable().getGraphic();
        if (graphic != null)
        {
            label.setGraphic(getSkinnable().getGraphic());
            addLabel();
        }
    }

    private void addLabel() {
        if (borderPane.getLeft() == null) {
            StackPane stackPane = new StackPane();
            stackPane.getChildren().add(label);
            borderPane.setLeft(stackPane);
        }
    }


}

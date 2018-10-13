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

import com.pixelduke.control.ribbon.RibbonGroup;
import javafx.collections.ListChangeListener;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.SkinBase;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.util.Collection;

public class RibbonGroupSkin extends SkinBase<RibbonGroup> {
    private final static int DEFAULT_SPACING = 0;

    private final HBox content;
    private final HBox container;
    private final Label title;

    /**
     * Constructor for all SkinBase instances.
     *
     * @param control The control for which this Skin should attach to.
     */
    public RibbonGroupSkin(RibbonGroup control) {
        super(control);

        content = new HBox();
        content.setAlignment(Pos.CENTER);
        content.setSpacing(DEFAULT_SPACING);

        Separator separator = new Separator(Orientation.VERTICAL);

        container = new HBox();

        title = new Label();
        StackPane titleContainer = new StackPane();
        titleContainer.getChildren().add(title);

        title.textProperty().bind(control.titleProperty());
        titleContainer.getStyleClass().setAll("title-container");
        title.getStyleClass().setAll("title");

        control.getNodes().addListener(this::buttonsChanged);
        updateAddedButtons(control.getNodes());

        VBox vBox = new VBox();
        vBox.getChildren().addAll(content, titleContainer);
        container.getChildren().addAll(vBox, separator);

        getChildren().add(container);

        content.getStyleClass().setAll("ribbon-group-content");

    }

    private void updateAddedButtons(Collection<? extends Node> nodes) {
        for (Node node : nodes)
            content.getChildren().add(node);
    }

    private void buttonsChanged(ListChangeListener.Change<? extends Node> changed) {
        while(changed.next())
        {
            if (changed.wasAdded())
            {
                updateAddedButtons(changed.getAddedSubList());
            }
            if(changed.wasRemoved())
            {
                for (Node node : changed.getRemoved())
                    content.getChildren().remove(node);
            }
        }
    }


}

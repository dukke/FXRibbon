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

import com.pixelduke.control.ribbon.QuickAccessBar;
import javafx.collections.ListChangeListener;
import javafx.scene.control.Button;
import javafx.scene.control.SkinBase;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import java.util.Collection;

public class QuickAccessBarSkin extends SkinBase<QuickAccessBar> {
    private final BorderPane outerContainer;
    private final HBox buttonContainer;
    private final HBox rightButtons;

    /**
     * Constructor for all SkinBase instances.
     *
     * @param control The control for which this Skin should attach to.
     */
    public QuickAccessBarSkin(QuickAccessBar control) {
        super(control);
        buttonContainer = new HBox();
        rightButtons = new HBox();
        outerContainer = new BorderPane();
        buttonContainer.getStyleClass().add("button-container");
        outerContainer.getStyleClass().add("outer-container");

        outerContainer.setCenter(buttonContainer);
        outerContainer.setRight(rightButtons);
        getChildren().add(outerContainer);
        updateAddedButtons(control.getButtons());
    }

    private void buttonsChanged(ListChangeListener.Change<? extends Button> changed) {
        while(changed.next())
        {
            if (changed.wasAdded())
            {
                updateAddedButtons(changed.getAddedSubList());
            }
            if(changed.wasRemoved())
            {
                for (Button button : changed.getRemoved())
                    buttonContainer.getChildren().remove(button);
            }
        }
    }

    private void updateAddedButtons(Collection<? extends Button> addedSubList) {
        QuickAccessBar skinnable = getSkinnable();
        for (Button button : skinnable.getButtons())
        {
            buttonContainer.getChildren().add(button);
        }
        for (Button button : skinnable.getRightButtons())
            rightButtons.getChildren().add(button);
    }


}

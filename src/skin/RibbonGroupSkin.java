package com.pixelduke.javafx.ribbon.skin;

import com.pixelduke.javafx.ribbon.RibbonGroup;
import javafx.collections.ListChangeListener;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.SkinBase;
import javafx.scene.layout.HBox;

import java.util.Collection;

/**
 * Created by pedro_000 on 1/20/14.
 */
public class RibbonGroupSkin extends SkinBase<RibbonGroup> {
    public static int CONTENT_HEIGHT = 112;
    public static int DEFAULT_SPACING = 10;

    private HBox content;

    /**
     * Constructor for all SkinBase instances.
     *
     * @param control The control for which this Skin should attach to.
     */
    public RibbonGroupSkin(RibbonGroup control) {
        super(control);

        content = new HBox();
        content.setMinHeight(CONTENT_HEIGHT);
        content.setAlignment(Pos.CENTER);
        content.setSpacing(DEFAULT_SPACING);

        control.getNodes().addListener(new ListChangeListener<Node>() {
            @Override
            public void onChanged(Change<? extends Node> changed) {
                buttonsChanged(changed);
            }
        });
        updateAddedButtons(control.getNodes());
        getChildren().add(content);

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

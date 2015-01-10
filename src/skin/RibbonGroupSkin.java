package com.pixelduke.javafx.ribbon.skin;

import com.pixelduke.javafx.ribbon.RibbonGroup;
import com.sun.javafx.scene.control.skin.LabeledText;
import javafx.collections.ListChangeListener;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Separator;
import javafx.scene.control.SkinBase;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.util.Collection;

/**
 * Created by pedro_000 on 1/20/14.
 */
public class RibbonGroupSkin extends SkinBase<RibbonGroup> {
    public static int CONTENT_HEIGHT = 112;
    public static int DEFAULT_SPACING = 0;

    private HBox content;
    private HBox container;
    private LabeledText title;

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

        Separator separator = new Separator(Orientation.VERTICAL);

        container = new HBox();

        title = new LabeledText(control);
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(title);

        title.textProperty().bind(control.titleProperty());
        title.getStyleClass().setAll("title");

        control.getNodes().addListener(new ListChangeListener<Node>() {
            @Override
            public void onChanged(Change<? extends Node> changed) {
                buttonsChanged(changed);
            }
        });
        updateAddedButtons(control.getNodes());

        VBox vBox = new VBox();
        vBox.getChildren().addAll(content, stackPane);
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

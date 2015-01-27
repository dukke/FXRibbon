package com.pixelduke.javafx.ribbon.skin;

import com.pixelduke.javafx.ribbon.RibbonItem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.SkinBase;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

/**
 * Created by pedro_000 on 1/19/2015.
 */
public class RibbonItemSkin extends SkinBase<RibbonItem> {

    BorderPane borderPane;
    Label label;

    /**
     * Constructor for all SkinBase instances.
     *
     * @param control The control for which this Skin should attach to.
     */
    public RibbonItemSkin(RibbonItem control) {
        super(control);

        borderPane = new BorderPane();
        label = new Label();

        control.graphicProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                graphicChanged();
            }
        });
        control.labelPropery().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                labelChanged();
            }
        });
        control.itemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                itemChanged();
            }
        });

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

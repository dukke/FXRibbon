package com.pixelduke.javafx.ribbon.skin;

import com.pixelduke.javafx.ribbon.Gallery;
import com.pixelduke.javafx.ribbon.GalleryItem;
import com.pixelduke.javafx.ribbon.GalleryPopup;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.SkinBase;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.util.HashMap;

/**
 * Created by pedro_000 on 1/13/2015.
 */
public class GallerySkin extends SkinBase<Gallery> {
    public static final double CONTENT_HEIGHT = RibbonGroupSkin.CONTENT_HEIGHT - 20;

    private StackPane upButton, downButton, popupButton;
    private HBox graphicsContainer;

    private Region upButtonGraphic, downButtonGraphic, popupButtonGraphic;

    private StackPane selectedContainer;

    private HashMap<GalleryItem, StackPane> itemContainer;
    private HashMap<StackPane, GalleryItem> containerItem;

    private int scrollIndex;

    private GalleryPopup popup;

    /**
     * Constructor for all SkinBase instances.
     *
     * @param control The control for which this Skin should attach to.
     */
    public GallerySkin(Gallery control) {
        super(control);

        scrollIndex = 0;

        itemContainer = new HashMap<>();
        containerItem = new HashMap<>();

        upButton = new StackPane();
        upButton.getStyleClass().setAll("up-button");
        upButton.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                mousePressedOnUpButton();
            }
        });

        downButton = new StackPane();
        downButton.getStyleClass().setAll("down-button");
        downButton.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                mousePressedOnDownButton();
            }
        });

        control.selectedItemProperty().addListener(new ChangeListener<GalleryItem>() {
            @Override
            public void changed(ObservableValue<? extends GalleryItem> observable, GalleryItem oldValue, GalleryItem newValue) {
                selectedItemChanged();
            }
        });
        control.getItems().addListener(new ListChangeListener<GalleryItem>() {
            @Override
            public void onChanged(Change<? extends GalleryItem> c) {
                updateItemMap();
            }
        });

        popupButton = new StackPane();
        popupButton.getStyleClass().setAll("popup-button");

        graphicsContainer = new HBox();
        graphicsContainer.getStyleClass().setAll("container");

        upButtonGraphic = new Region();
        upButtonGraphic.getStyleClass().setAll("up-button-graphic");
        upButtonGraphic.setFocusTraversable(false);
        upButtonGraphic.setMaxHeight(Region.USE_PREF_SIZE);
        upButtonGraphic.setMaxWidth(Region.USE_PREF_SIZE);


        downButtonGraphic = new Region();
        downButtonGraphic.getStyleClass().setAll("down-button-graphic");
        downButtonGraphic.setFocusTraversable(false);
        downButtonGraphic.setMaxWidth(Region.USE_PREF_SIZE);
        downButtonGraphic.setMaxHeight(Region.USE_PREF_SIZE);

        popupButtonGraphic = new Region();
        popupButtonGraphic.getStyleClass().setAll("popup-button-graphic");
        popupButtonGraphic.setFocusTraversable(false);
        popupButtonGraphic.setMaxWidth(Region.USE_PREF_SIZE);
        popupButtonGraphic.setMaxHeight(Region.USE_PREF_SIZE);

        upButton.getChildren().add(upButtonGraphic);
        downButton.getChildren().add(downButtonGraphic);
        popupButton.getChildren().add(popupButtonGraphic);

        getChildren().addAll(graphicsContainer, upButton, downButton, popupButton);
        updateItemMap();

        updateVisibleItems();
        updateButtonEnabledState();

        popup = new GalleryPopup(control);
        popupButton.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                mousePressedOnPopupButton();
            }
        });
    }

    private void updateItemMap() {
        for (GalleryItem item : getSkinnable().getItems())
        {
            if (itemContainer.get(item) != null)
                continue;

            StackPane container = createItemContainer(item);
            itemContainer.put(item, container);
            containerItem.put(container, item);
        }
    }

    private void mousePressedOnPopupButton() {
        Gallery skinnable = getSkinnable();

        Point2D position = skinnable.localToScreen(0, 0);

        popup.show(skinnable, position.getX(), position.getY());

    }

    private void selectedItemChanged() {
        GalleryItem selectedItem = getSkinnable().getSelectedItem();

        if (selectedContainer != null)
        {
            selectedContainer.getStyleClass().remove("selected");
        }

        if (selectedItem != null)
        {
            selectedContainer = itemContainer.get(selectedItem);
            selectedContainer.getStyleClass().add("selected");
        }
    }

    private void mousePressedOnDownButton() {
        if (downButton.getStyleClass().indexOf("disabled") != -1)
            return;

        ++scrollIndex;
        updateVisibleItems();
        updateButtonEnabledState();
    }

    private void mousePressedOnUpButton() {
        if (upButton.getStyleClass().indexOf("disabled") != -1)
            return;

        --scrollIndex;
        updateVisibleItems();
        updateButtonEnabledState();
    }

    private void updateVisibleItems() {
        Gallery gallery = getSkinnable();
        if (gallery.getItems().size() == 0)
            return;

        GalleryItem item = gallery.getItems().get(scrollIndex);

        StackPane graphicContainer = null;

        graphicContainer = itemContainer.get(item);

        final StackPane finalGraphicContainer = graphicContainer;
        graphicContainer.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                mousePressedOnItem(finalGraphicContainer);
            }
        });
        graphicsContainer.getChildren().setAll(graphicContainer);
    }

    private StackPane createItemContainer(GalleryItem item) {
        StackPane graphicContainer;
        graphicContainer = new StackPane();
        graphicContainer.setPrefWidth(CONTENT_HEIGHT);
        graphicContainer.setPrefHeight(CONTENT_HEIGHT);
        graphicContainer.getStyleClass().setAll("item");
        if (item.getName() != null) {
            VBox vBox = new VBox();
            vBox.setMaxHeight(Region.USE_PREF_SIZE);
            vBox.setMaxWidth((Region.USE_PREF_SIZE));
            vBox.setAlignment(Pos.CENTER);
            Label title = new Label(item.getName());
            vBox.getChildren().addAll(item.getGraphic(), title);
            graphicContainer.getChildren().add(vBox);
        }else
            graphicContainer.getChildren().add(item.getGraphic());
        return graphicContainer;
    }

    private void mousePressedOnItem(StackPane graphicContainer) {
        if (graphicContainer.getStyleClass().indexOf("selected") != -1)
            return;

        getSkinnable().setSelectedItem(containerItem.get(graphicContainer));
    }

    private void updateButtonEnabledState()
    {
        Gallery gallery = getSkinnable();

        if (scrollIndex == 0)
        {
            if (upButton.getStyleClass().indexOf("disabled") == -1)
                upButton.getStyleClass().add("disabled");
        } if (gallery.getItems().size() / gallery.getNumOfVisibleItems() - 1 == scrollIndex)
        {
            if (downButton.getStyleClass().indexOf("disabled") == -1)
                downButton.getStyleClass().add("disabled");
        } if (scrollIndex > 0) {
            upButton.getStyleClass().remove("disabled");
        } if (gallery.getItems().size() / gallery.getNumOfVisibleItems() - 1 > scrollIndex)
            downButton.getStyleClass().remove("disabled");

    }


    @Override
    protected void layoutChildren(double x, double y, double w, double h) {
        super.layoutChildren(x, y, w, h);

        final double upGraphicWidth = snapSize(upButtonGraphic.prefWidth(-1));
        final double upGraphicHeight = snapSize(upButtonGraphic.prefWidth(-1));
        final double upButtonWidth = upButton.snappedLeftInset() + upGraphicWidth + upButton.snappedRightInset();
        final double upButtonHeight = upButton.snappedBottomInset() + upGraphicHeight + upButton.snappedTopInset();

        upButton.resize(upButtonWidth, upButtonHeight);
        upButton.setLayoutX(CONTENT_HEIGHT * getSkinnable().getNumOfVisibleItems()- 1);
        upButton.setLayoutY(0);

        final double downGraphicWidth = snapSize(downButtonGraphic.prefWidth(-1));
        final double downGraphicHeight = snapSize(downButtonGraphic.prefHeight(-1));
        final double downButtonWidth = downButton.snappedLeftInset() + downGraphicWidth + downButton.snappedRightInset();
        final double downButtonHeight = downButton.snappedBottomInset() + downGraphicHeight + downButton.snappedTopInset();

        downButton.resize(downButtonWidth, downButtonHeight);
        downButton.setLayoutX(CONTENT_HEIGHT * getSkinnable().getNumOfVisibleItems() - 1);
        downButton.setLayoutY(upButtonHeight);

        final double popupGraphicWidth = snapSize(popupButtonGraphic.prefWidth(-1));
        final double popupGraphicHeight = snapSize(popupButtonGraphic.prefHeight(-1));
        final double popupButtonWidth = popupButton.snappedLeftInset() + popupGraphicWidth + popupButton.snappedRightInset();
        final double popupButtonHeight = popupButton.snappedTopInset() + popupGraphicHeight + popupButton.snappedBottomInset();

        popupButton.resize(popupButtonWidth, popupButtonHeight);
        popupButton.setLayoutX(CONTENT_HEIGHT * getSkinnable().getNumOfVisibleItems() - 1);
        popupButton.setLayoutY(upButtonHeight + downButtonHeight);

        final double graphicContainerHeight = CONTENT_HEIGHT;
        graphicsContainer.resize(CONTENT_HEIGHT * getSkinnable().getNumOfVisibleItems(), graphicContainerHeight);
    }

    @Override
    protected double computeMinWidth(double height, double topInset, double rightInset, double bottomInset, double leftInset) {
        double buttonWidth = upButton.prefWidth(-1);
        return leftInset + CONTENT_HEIGHT * getSkinnable().getNumOfVisibleItems() + buttonWidth + rightInset;
    }

    @Override
    protected double computeMinHeight(double width, double topInset, double rightInset, double bottomInset, double leftInset) {
        return topInset + CONTENT_HEIGHT + bottomInset;
    }

    @Override
    protected double computePrefWidth(double height, double topInset, double rightInset, double bottomInset, double leftInset) {
        double buttonWidth = upButton.prefWidth(-1);
        return leftInset + CONTENT_HEIGHT * getSkinnable().getNumOfVisibleItems() + buttonWidth + rightInset;
    }

    @Override
    protected double computePrefHeight(double width, double topInset, double rightInset, double bottomInset, double leftInset) {
        return topInset + CONTENT_HEIGHT + bottomInset;
    }

}

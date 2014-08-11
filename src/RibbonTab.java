package com.pixelduke.javafx.ribbon;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.Separator;
import javafx.scene.control.Tab;
import javafx.scene.layout.HBox;

import java.util.List;

/**
 * Created by pedro_000 on 1/20/14.
 */
public class RibbonTab extends Tab {
    public static final int CONTENT_HEIGHT = 130;
    public static final String DEFAULT_STYLE_CLASS = "ribbon-tab";

    HBox content;

    ObservableList<RibbonGroup> ribbonGroups;

    public RibbonTab()
    {
        init();
    }

    public RibbonTab(String title)
    {
        super(title);
        init();
    }

    private void init() {
        ribbonGroups = FXCollections.observableArrayList();
        content = new HBox();
        content.setMinHeight(CONTENT_HEIGHT);
        this.setContent(content);

        setClosable(false);

        ribbonGroups.addListener(new ListChangeListener<RibbonGroup>() {
            @Override
            public void onChanged(Change<? extends RibbonGroup> changed) {
                groupsChanged(changed);
            }
        });
        content.getStyleClass().setAll(DEFAULT_STYLE_CLASS, "tab");
        getStyleClass().addListener(new ListChangeListener<String>() {
            @Override
            public void onChanged(Change<? extends String> c) {
                while(c.next())
                {
                    if (c.wasAdded())
                    {
                        for (String style : c.getAddedSubList())
                        {
                            content.getStyleClass().add(style);
                        }
                    }
                }
            }
        });
    }

    private void groupsChanged(ListChangeListener.Change<? extends RibbonGroup> changed) {
        while(changed.next())
        {
            if (changed.wasAdded())
            {
                updateAddedGroups(changed.getAddedSubList());
            }
            if(changed.wasRemoved())
            {
                for (RibbonGroup group : changed.getRemoved())
                {
                    int groupIndex = content.getChildren().indexOf(group);
                    if (groupIndex != 0)
                        content.getChildren().remove(groupIndex - 1); // Remove separator
                    content.getChildren().remove(group);

                }

            }
        }
    }

    private void updateAddedGroups(List<? extends RibbonGroup> addedSubList) {
        for (RibbonGroup group : addedSubList)
        {
            if (content.getChildren().size() != 0)
                content.getChildren().add(createSeparator());
            content.getChildren().add(group);
        }
    }

    private Node createSeparator() {
        Separator separator = new Separator();
        separator.setOrientation(Orientation.VERTICAL);
        return separator;
    }

    public ObservableList<RibbonGroup> getRibbonGroups()
    {
        return ribbonGroups;
    }
}

package com.pixelduke.javafx.ribbon;

import javafx.scene.Node;

import javax.swing.text.html.ImageView;

/**
 * Created by pedro_000 on 1/13/2015.
 */
public class GalleryItem {

    private String name;
    private String category;
    private Node graphic;

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    public String getCategory()
    {
        return category;
    }

    public void setGraphic(Node graphic)
    {
        this.graphic = graphic;
    }

    public Node getGraphic()
    {
        return graphic;
    }
}

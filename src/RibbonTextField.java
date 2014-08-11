package com.pixelduke.javafx.ribbon;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

/**
 * Created by pedro_000 on 1/22/14.
 */
public class RibbonTextField extends VBox {
    public static final String DEFAULT_STYLE_CLASS = "ribbon-text-field";
    private TextField textField;
    private Label label;

    public RibbonTextField()
    {
        init();
    }

    public RibbonTextField(String label)
    {
        init();
        setLabel(label);
    }

    private void init() {
        textField = new TextField();
        getChildren().add(textField);
        setMaxHeight(Region.USE_PREF_SIZE); // It also centers the textfield as a side effect
        getStyleClass().setAll(DEFAULT_STYLE_CLASS);
//        setSpacing(2);
    }

    public void setLabel(String label){
        if (this.label == null)
        {
            this.label = new Label();
            getChildren().add(0, this.label);
        }
        this.label.setText(label);
    }

    public String getLabel(){
        return this.label.getText();
    }

    public void setText(String text)
    {
        textField.setText(text);
    }

    public String getText()
    {
        return textField.getText();
    }

    public void setPromptText(String promptText)
    {
        textField.setPromptText(promptText);
    }

    public String getPromptText()
    {
        return textField.getPromptText();
    }
}

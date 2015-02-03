/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication7;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.embed.swing.SwingNode;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Test {

    private static final int JFXPANEL_WIDTH_INT = 300;
    private static final int JFXPANEL_HEIGHT_INT = 250;

    private static void initAndShowGUI() {
        // This method is invoked on the EDT thread
        JFrame frame = new JFrame("Swing and JavaFX");
        final JFXPanel fxPanel = new JFXPanel();
//        frame.add(fxPanel);
        frame.setSize(JFXPANEL_WIDTH_INT, JFXPANEL_HEIGHT_INT);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Platform.runLater(() -> {
            createfxContainer(frame, fxPanel);
        });
    }

    private static void createfxContainer(Container container, JFXPanel fxContainer) {
        fxContainer.setPreferredSize(new Dimension(JFXPANEL_WIDTH_INT, JFXPANEL_HEIGHT_INT));
        container.add(fxContainer, BorderLayout.CENTER);
        // create JavaFX scene
        Platform.runLater(() -> {
            createJavaFXScene(fxContainer);
        });
    }

    private static void createJavaFXScene(JFXPanel fxContainer) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        BorderPane root = new BorderPane();
        root.setBackground(new Background(new BackgroundFill(Color.GREENYELLOW, CornerRadii.EMPTY, new Insets(10))));
        btn.setOnAction(event -> {
            SwingNode swingNode = new SwingNode();
            createSwingContent(swingNode);
            StackPane stackPane = new StackPane(swingNode);
            stackPane.setPadding(new Insets(10));
            root.setCenter(stackPane);
        });
        root.setLeft(btn);
        fxContainer.setScene(new Scene(root));
    }

    private static void createSwingContent(final SwingNode swingNode) {
        JPanel p = new JPanel(new BorderLayout());
        final JButton jButton = new JButton("Click me!");
        jButton.setPreferredSize(new Dimension(20, 10));
        p.add(jButton, BorderLayout.EAST);
        jButton.addActionListener(e -> createfxContainer(p, new JFXPanel()));
        swingNode.setContent(p);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                initAndShowGUI();
            }
        });
    }
}
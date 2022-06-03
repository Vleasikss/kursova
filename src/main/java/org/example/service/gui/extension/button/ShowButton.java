package org.example.service.gui.extension.button;

import org.example.service.gui.tab.FrameTab;

import javax.swing.*;

/**
 * extension of JButton which contains an additional listener per each click {@link ShowButton#ShowButton(FrameTab, String)}
 */
public class ShowButton extends JButton {

    public ShowButton(FrameTab frameTab) {
        this(frameTab, frameTab.title());
    }

    /**
     * Creates a listener which calls {@link FrameTab#show()} per each button click
     * @param frameTab frame tab to show
     * @param title button title
     */
    public ShowButton(FrameTab frameTab, String title) {
        setText(title);
        addActionListener(e -> frameTab.show());
    }

}

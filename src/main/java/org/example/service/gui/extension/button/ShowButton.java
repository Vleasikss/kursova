package org.example.service.gui.extension.button;

import org.example.service.gui.tab.FrameTab;

import javax.swing.*;

public class ShowButton extends JButton {

    public ShowButton(FrameTab frameTab) {
        this(frameTab, frameTab.title());
    }

    public ShowButton(FrameTab frameTab, String title) {
        setText(title);
        addActionListener(e -> frameTab.show());
    }

}

package org.example.service.gui.extension.button;

import org.example.service.gui.tab.FrameTab;

import javax.swing.*;

public class ShowButton extends JButton {

    public ShowButton(FrameTab frameTab) {
        setText(frameTab.title());
        addActionListener(e -> frameTab.show());
    }

}

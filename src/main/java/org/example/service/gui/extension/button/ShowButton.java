package org.example.service.gui.extension.button;

import org.example.service.gui.tab.FrameTab;

import javax.swing.*;

public class ShowButton extends JButton {

    public ShowButton(FrameTab byIdTab) {
        setText(byIdTab.title());
        addActionListener(e -> byIdTab.show());
    }
}

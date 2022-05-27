package org.example.service.gui.tab;

import org.example.service.gui.ApplicationTabbedPane;

import java.awt.*;

public interface FrameTab {

    String title();

    Component apply();

    default void show() {
        ApplicationTabbedPane pane = ApplicationTabbedPane.getInstance();
        pane.setSelectedIndex(pane.indexOfTab(title()));
    }

}

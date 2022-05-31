package org.example.service.gui.tab;

import org.example.service.gui.ApplicationTabbedPaneSingleton;

import java.awt.*;

public interface FrameTab {

    String title();

    Component apply();

    default void show() {
        ApplicationTabbedPaneSingleton pane = ApplicationTabbedPaneSingleton.getInstance();
        if (pane.indexOfTab(title()) == -1) {
            pane.addTab(this);
        }
        pane.setSelectedIndex(pane.indexOfTab(title()));
    }

}

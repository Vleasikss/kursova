package org.example.service.gui.tab;

import org.example.service.gui.ApplicationTabbedPane;

import java.awt.*;
import java.util.List;

public interface FrameTab {

    String title();

    List<Component> components();

    default void show() {
        ApplicationTabbedPane pane = ApplicationTabbedPane.getInstance();
        if (pane.indexOfTab(title()) == -1) {
            pane.addTab(this);
        }
        pane.setSelectedIndex(pane.indexOfTab(title()));
    }

    default void reload() {
        ApplicationTabbedPane pane = ApplicationTabbedPane.getInstance();
        int indexOfTab = pane.indexOfTab(title());
        if (indexOfTab == -1) {
            return;
        }
        pane.removeTabAt(indexOfTab);
        show();
    }

}

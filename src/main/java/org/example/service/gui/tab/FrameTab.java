package org.example.service.gui.tab;

import org.example.service.gui.ApplicationTabbedPane;

import java.awt.*;
import java.util.List;

/**
 * Abstraction over Frame Tabs
 */
public interface FrameTab {

    /**
     * @return Title of the page
     */
    String title();

    /**
     * @return components of the frame
     */
    List<Component> components();

    /**
     * Show this Frame Tab if not opened
     */
    default void show() {
        ApplicationTabbedPane pane = ApplicationTabbedPane.getInstance();
        if (pane.indexOfTab(title()) == -1) {
            pane.addTab(this);
        }
        pane.setSelectedIndex(pane.indexOfTab(title()));
    }


    /**
     * Reload this Frame Tab (remove and {@link FrameTab#show()} it again if page is opened
     */
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

package org.example.service.gui;

import org.example.service.gui.tab.FrameTab;

import javax.swing.*;

/**
 * Main Final Singleton Application Tabbed Pane
 */
public final class ApplicationTabbedPane extends JTabbedPane {

    private static ApplicationTabbedPane applicationTabbedPane = null;

    private ApplicationTabbedPane() {
        setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);
        setOpaque(false);
    }

    public static ApplicationTabbedPane getInstance() {
        if (applicationTabbedPane == null) {
            applicationTabbedPane = new ApplicationTabbedPane();
        }
        return applicationTabbedPane;
    }

    public void addTab(FrameTab frameTab) {
        final JPanel content = new JPanel();
        frameTab.components().forEach(content::add);
        addTab(frameTab.title(), content);
    }

}

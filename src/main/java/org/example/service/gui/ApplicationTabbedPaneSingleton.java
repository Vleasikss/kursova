package org.example.service.gui;

import org.example.service.gui.tab.FrameTab;

import javax.swing.*;

public class ApplicationTabbedPaneSingleton extends JTabbedPane {

    private static ApplicationTabbedPaneSingleton applicationTabbedPane = null;

    public void addAllTabs(FrameTab... frameTabList) {
        for (FrameTab frameTab : frameTabList) {
            addTab(frameTab);
        }
    }

    public void addTab(FrameTab frameTab) {
        addTab(frameTab.title(), frameTab.apply());
    }

    private ApplicationTabbedPaneSingleton() {
        setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);
    }

    public static ApplicationTabbedPaneSingleton getInstance() {
        if (applicationTabbedPane == null) {
            applicationTabbedPane = new ApplicationTabbedPaneSingleton();
        }
        return applicationTabbedPane;
    }

}

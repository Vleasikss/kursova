package org.example.service.gui;

import org.example.service.gui.tab.FrameTab;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ApplicationTabbedPane extends JTabbedPane {

    private static ApplicationTabbedPane applicationTabbedPane = null;

    public void addAll(List<FrameTab> frameTabList) {
        frameTabList.forEach(frameTab -> addTab(frameTab.title(), frameTab.apply()));
    }

    private ApplicationTabbedPane() {

    }

    public static ApplicationTabbedPane getInstance() {
        if (applicationTabbedPane == null) {
            applicationTabbedPane = new ApplicationTabbedPane();
        }
        return applicationTabbedPane;
    }

}

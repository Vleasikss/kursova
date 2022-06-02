package org.example;

import org.example.service.gui.ApplicationFrame;
import org.example.service.gui.ApplicationTabbedPane;
import org.example.service.gui.tab.AllFacultiesTab;
import org.example.service.gui.tab.AllGroupsTab;
import org.example.service.gui.tab.AllStudentsTab;

public class Main {

    private static final ApplicationTabbedPane pane = ApplicationTabbedPane.getInstance();
    private static final ApplicationFrame frame = new ApplicationFrame(
            "application-title",
            pane
    );

    public static void main(String[] args) {
        pane.addTab(AllFacultiesTab.getInstance());
        pane.addTab(AllStudentsTab.getInstance());
        pane.addTab(AllGroupsTab.getInstance());

        frame.perform();
    }

}

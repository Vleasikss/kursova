package org.example;

import org.example.service.gui.ApplicationFrame;
import org.example.service.gui.ApplicationTabbedPane;
import org.example.service.gui.tab.StartTab;


public class Main {

    private static final ApplicationTabbedPane pane = ApplicationTabbedPane.getInstance();
    private static final ApplicationFrame frame = new ApplicationFrame(
            "student-management-system",
            pane
    );

    public static void main(String[] args) {
        pane.addTab(new StartTab());
        frame.perform();
    }

}

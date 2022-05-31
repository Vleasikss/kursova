package org.example;

import org.example.service.gui.ApplicationFrame;
import org.example.service.gui.ApplicationTabbedPaneSingleton;
import org.example.service.gui.tab.AllFacultiesTab;
import org.example.service.gui.tab.AllStudentsTab;

public class Main {

    private static final ApplicationFrame frame = new ApplicationFrame(
            "application-title",
            ApplicationTabbedPaneSingleton.getInstance()
    );

    public static void main(String[] args) {
        new AllFacultiesTab().show();
        frame.perform();
    }

}

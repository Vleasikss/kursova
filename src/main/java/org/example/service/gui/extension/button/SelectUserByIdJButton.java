package org.example.service.gui.extension.button;

import org.example.service.gui.ApplicationTabbedPane;
import org.example.service.gui.tab.StudentByIdTab;

import javax.swing.*;

public class SelectUserByIdJButton extends JButton {

    public SelectUserByIdJButton(StudentByIdTab byIdTab) {
        setText(byIdTab.title());
        addActionListener(e -> openTab(byIdTab));
    }

    private static void openTab(StudentByIdTab byIdTab) {
        ApplicationTabbedPane pane = ApplicationTabbedPane.getInstance();
        if (pane.indexOfTab(byIdTab.title()) == -1) {
            pane.add(byIdTab.title(), byIdTab.apply());
        }
        byIdTab.show();
    }
}

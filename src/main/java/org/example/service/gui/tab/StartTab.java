package org.example.service.gui.tab;

import org.example.service.gui.extension.button.ShowButton;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Frame Tab which shows welcome message with all the pages
 */
public class StartTab implements FrameTab {

    private static final String START_TAB_TITLE = "start-page";

    private static final Font START_PAGE_TITLE_FONT = new Font("Arial", Font.PLAIN, 38);
    private final JLabel welcomeLabel;

    public StartTab() {
        JLabel welcomeLabel = new JLabel("Welcome to Students' Management System: ");
        welcomeLabel.setFont(START_PAGE_TITLE_FONT);
        welcomeLabel.setBackground(Color.orange);
        this.welcomeLabel = welcomeLabel;

    }

    @Override
    public String title() {
        return START_TAB_TITLE;
    }

    @Override
    public List<Component> components() {
        return List.of(
                welcomeLabel,
                new ShowButton(AllFacultiesTab.getInstance()),
                new ShowButton(AllStudentsTab.getInstance()),
                new ShowButton(AllGroupsTab.getInstance())
        );
    }

}

package org.example.service.gui.tab;

import org.example.service.gui.extension.button.ShowButton;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Frame Tab which shows welcome message with all the pages
 */
public class StartTab implements FrameTab {

    private static final Font START_PAGE_TITLE_FONT = new Font("Arial", Font.PLAIN, 42);
    private final JLabel welcomeLabel;

    public StartTab() {
        JLabel welcomeLabel = new JLabel("Welcome! Check for these pages: ");
        welcomeLabel.setFont(START_PAGE_TITLE_FONT);
        welcomeLabel.setBackground(Color.orange);
        this.welcomeLabel = welcomeLabel;

    }

    @Override
    public String title() {
        return "start-page";
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

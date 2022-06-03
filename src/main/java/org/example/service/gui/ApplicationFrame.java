package org.example.service.gui;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public final class ApplicationFrame extends JFrame implements WindowListener {

    public ApplicationFrame(String title, JTabbedPane pane) {
        super(title);
        this.setContentPane(pane);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public void perform() {
        this.setVisible(true);
    }

    public void windowClosing(WindowEvent e) {
        dispose();
        System.exit(0);
    }

    public void windowOpened(WindowEvent e) {
    }

    public void windowActivated(WindowEvent e) {
    }

    public void windowIconified(WindowEvent e) {
    }

    public void windowDeiconified(WindowEvent e) {
    }

    public void windowDeactivated(WindowEvent e) {
    }

    public void windowClosed(WindowEvent e) {
    }

}
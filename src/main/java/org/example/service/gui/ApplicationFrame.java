package org.example.service.gui;

import org.example.service.gui.extension.FrameExtension;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;

public class ApplicationFrame extends JFrame implements WindowListener {

    private final List<FrameExtension> extensionList;


    private static final int DEFAULT_FRAME_WIDTH = 1200;
    private static final int DEFAULT_FRAME_HEIGHT = 600;

    public ApplicationFrame(String title) {
        super(title);
        this.extensionList = new ArrayList<>();
    }

    public void extend(FrameExtension extension) {
        this.extensionList.add(extension);
    }

    public void perform() {
        this.extensionList.forEach(extension -> add(extension.apply()));
        this.setSize(DEFAULT_FRAME_WIDTH, DEFAULT_FRAME_HEIGHT);
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
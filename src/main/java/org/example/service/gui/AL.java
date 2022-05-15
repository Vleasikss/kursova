package org.example.service.gui;

import org.example.model.Student;
import org.example.service.dao.StudentDatabaseHelper;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

public class AL extends Frame implements WindowListener, ActionListener {


    JTable jTable = new JTable();
    TextField text = new TextField(20);
    Button b;

    public AL(String title) {

        super(title);
        setLayout(new FlowLayout());
        addWindowListener(this);
        b = new Button("Click me");
        add(b);
        add(text);
        b.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {

        text.setText("clicked");
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
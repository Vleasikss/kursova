package org.example.service.gui.tab;

import org.example.model.Student;

import javax.swing.*;
import java.awt.*;

public class StudentByIdTab implements FrameTab {

    private final Student student;

    public StudentByIdTab(Student student) {
        this.student = student;
    }

    @Override
    public String title() {
        return student.getLastName() + " " + student.getFirstName();
    }

    @Override
    public Component apply() {
        return new JLabel(student.toString());
    }

}

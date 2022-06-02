package org.example.service.gui.tab;

import org.example.model.Student;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class StudentTab implements FrameTab {

    private final Student student;

    public StudentTab(Student student) {
        this.student = student;
    }

    @Override
    public String title() {
        return student.getLastName() + " " + student.getFirstName();
    }

    @Override
    public List<Component> components() {
        return List.of(new JLabel(student.toString()));
    }

}

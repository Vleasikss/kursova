package org.example.service.gui.tab;

import org.example.model.Student;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class StudentTab extends JFrame implements FrameTab {

    private static final Rectangle STUDENT_BOUNDS = new Rectangle(300, 90, 1200, 700);
    private static final Font ANY_LABEL_FONT = new Font("Arial", Font.PLAIN, 20);
    private static final Dimension ANY_LABEL_DIMENSION = new Dimension(500, 20);

    private final Student student;

    public StudentTab(Student student) {
        this.student = student;

        setTitle(title());
        setBounds(STUDENT_BOUNDS);

        Container c = getContentPane();
        c.setLayout(null);

        JLabel firstNameLabel = new JLabel("First name: " + student.getFirstName());
        firstNameLabel.setFont(ANY_LABEL_FONT);
        firstNameLabel.setSize(ANY_LABEL_DIMENSION);
        firstNameLabel.setLocation(400, 100);
        add(firstNameLabel);

        JLabel lastNameLabel = new JLabel("Last name: " + student.getLastName());
        lastNameLabel.setFont(ANY_LABEL_FONT);
        lastNameLabel.setSize(ANY_LABEL_DIMENSION);
        lastNameLabel.setLocation(400, 150);
        add(lastNameLabel);

        JLabel patronymicLabel = new JLabel("Patronymic: " + student.getPatronymic());
        patronymicLabel.setFont(ANY_LABEL_FONT);
        patronymicLabel.setSize(ANY_LABEL_DIMENSION);
        patronymicLabel.setLocation(400, 200);
        add(patronymicLabel);

        JLabel formLabel = new JLabel("Study form: " + student.getForm());
        formLabel.setFont(ANY_LABEL_FONT);
        formLabel.setSize(ANY_LABEL_DIMENSION);
        formLabel.setLocation(400, 250);
        add(formLabel);

        JLabel facultyLabel = new JLabel("Faculty: " + student.getFacultyId());
        facultyLabel.setFont(ANY_LABEL_FONT);
        facultyLabel.setSize(ANY_LABEL_DIMENSION);
        facultyLabel.setLocation(400, 300);
        add(facultyLabel);

        JLabel groupLabel = new JLabel("Group: " + student.getGroupId());
        groupLabel.setFont(ANY_LABEL_FONT);
        groupLabel.setSize(ANY_LABEL_DIMENSION);
        groupLabel.setLocation(400, 350);
        add(groupLabel);

        JLabel ratingScore = new JLabel("Rating score: " + student.getRatingScore());
        ratingScore.setFont(ANY_LABEL_FONT);
        ratingScore.setSize(ANY_LABEL_DIMENSION);
        ratingScore.setLocation(400, 400);
        add(ratingScore);

    }

    @Override
    public String title() {
        return student.getLastName() + " " + student.getFirstName();
    }

    @Override
    public List<Component> components() {
        return List.of(getComponents());
    }

}

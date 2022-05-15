package org.example;

import org.example.model.Student;
import org.example.service.dao.StudentDatabaseHelper;
import org.example.service.gui.AL;

import javax.swing.*;
import java.util.List;

public class Main {

    private static final StudentDatabaseHelper studentDatabaseHelper = new StudentDatabaseHelper();

    public static void main(String[] args) {
        JFrame frame = new JFrame("My First GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        AL myWindow = new AL("My first window");


        List<Student> all = studentDatabaseHelper.findAll();
        String[] column = {"id", "firstName", "lastName", "patronymic", "form", "groupId", "facultyId", "ratingScore"};

        Object[][] data = new Object[all.size()][column.length];

        for (int i = 0; i < all.size(); i++) {
            Student student = all.get(i);

            data[i][0] = student.getId();
            data[i][1] = student.getFirstName();
            data[i][2] = student.getLastName();
            data[i][3] = student.getPatronymic();
            data[i][4] = student.getForm();
            data[i][5] = student.getGroupId();
            data[i][6] = student.getFacultyId();
            data[i][7] = student.getRatingScore();
        }

        JTable jt = new JTable(data, column);

        jt.setBounds(30, 40, 200, 300);
        JScrollPane sp = new JScrollPane(jt);

        myWindow.add(sp);
        myWindow.add(jt);

        myWindow.setSize(350, 100);
        myWindow.setVisible(true);


    }

}

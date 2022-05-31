package org.example.service.gui.extension.table;

import org.example.model.Student;
import org.example.service.gui.extension.FrameExtension;
import org.example.service.gui.extension.button.ShowButton;
import org.example.service.gui.extension.table.util.JTableButtonModel;
import org.example.service.gui.extension.table.util.JTableButtonMouseListener;
import org.example.service.gui.extension.table.util.JTableButtonRenderer;
import org.example.service.gui.tab.id.StudentByIdTab;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.List;

public class StudentsTableFrameExtension implements FrameExtension {

    private static final int TABLE_X = 30;
    private static final int TABLE_Y = 40;
    private static final int TABLE_WIDTH = 200;
    private static final int TABLE_HEIGHT = 300;

    private final List<Student> students;

    public StudentsTableFrameExtension(List<Student> students) {
        this.students = students;
    }

    @Override
    public Component apply() {
        String[] columns = {"action", "id", "firstName", "lastName", "patronymic", "form", "groupId", "facultyId", "ratingScore"};
        Object[][] data = new Object[students.size()][columns.length];

        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);

            StudentByIdTab studentByIdTab = new StudentByIdTab(student);

            data[i][0] = new ShowButton(studentByIdTab);
            data[i][1] = i + 1;
            data[i][2] = student.getFirstName();
            data[i][3] = student.getLastName();
            data[i][4] = student.getPatronymic();
            data[i][5] = student.getForm();
            data[i][6] = student.getGroupId();
            data[i][7] = student.getFacultyId();
            data[i][8] = student.getRatingScore();
        }

        JTable jt = new JTable(new JTableButtonModel(data, columns));
        jt.addMouseListener(new JTableButtonMouseListener(jt));

        TableCellRenderer tableRenderer = jt.getDefaultRenderer(JButton.class);
        jt.setDefaultRenderer(JButton.class, new JTableButtonRenderer(tableRenderer));
        jt.setBounds(TABLE_X, TABLE_Y, TABLE_WIDTH, TABLE_HEIGHT);

        return new JScrollPane(jt);
    }

}

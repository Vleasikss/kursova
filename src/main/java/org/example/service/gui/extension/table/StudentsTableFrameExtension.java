package org.example.service.gui.extension.table;

import org.example.model.Student;
import org.example.service.gui.extension.FrameExtension;
import org.example.service.gui.extension.button.ShowButton;
import org.example.service.gui.extension.table.util.JTableButtonModel;
import org.example.service.gui.extension.table.util.JTableButtonMouseListener;
import org.example.service.gui.extension.table.util.JTableButtonRenderer;
import org.example.service.gui.tab.StudentTab;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudentsTableFrameExtension implements FrameExtension {

    private static final Dimension STUDENTS_TABLE_DIMENSION = new Dimension(1400, 800);

    private final List<Student> students;

    public StudentsTableFrameExtension(List<Student> students) {
        this.students = students;
    }

    @Override
    public Component apply() {
        String[] columns = {"action", "id", "firstName", "lastName", "patronymic", "form", "groupId", "facultyId", "course"};
        Object[][] data = new Object[students.size()][columns.length];

        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);

            StudentTab studentByIdTab = new StudentTab(student);

            data[i][0] = new ShowButton(studentByIdTab);
            data[i][1] = i + 1;
            data[i][2] = student.getFirstName();
            data[i][3] = student.getLastName();
            data[i][4] = student.getPatronymic();
            data[i][5] = student.getForm();
            data[i][6] = student.getGroupId();
            data[i][7] = student.getFacultyId();
            data[i][8] = extractCourseFromGroupName(student.getGroupId());
        }

        JTable jt = new JTable(new JTableButtonModel(data, columns));
        jt.addMouseListener(new JTableButtonMouseListener(jt));

        TableCellRenderer tableRenderer = jt.getDefaultRenderer(JButton.class);
        jt.setDefaultRenderer(JButton.class, new JTableButtonRenderer(tableRenderer));
        jt.setPreferredScrollableViewportSize(STUDENTS_TABLE_DIMENSION);
        jt.setFillsViewportHeight(true);
        return new JScrollPane(jt);
    }

    private static int extractCourseFromGroupName(String groupId) {
        Pattern pattern = Pattern.compile("-.*");
        Matcher matcher = pattern.matcher(groupId);
        if (matcher.find()) {
            String after = matcher.group();
            return Integer.parseInt(String.valueOf(after.toCharArray()[1]));
        }
        return 0;
    }

}

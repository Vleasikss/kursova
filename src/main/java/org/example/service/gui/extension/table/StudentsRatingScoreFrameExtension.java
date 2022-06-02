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

public class StudentsRatingScoreFrameExtension implements FrameExtension {

    private final List<Student> students;
    private static final Dimension STUDENTS_TABLE_DIMENSION = new Dimension(700, 800);

    public StudentsRatingScoreFrameExtension(List<Student> students) {
        this.students = students;
    }

    @Override
    public Component apply() {
        String[] columns = {"id", "student", "ratingScore"};
        Object[][] data = new Object[students.size()][columns.length];
        students.sort((s1, s2) -> Double.compare(s2.getRatingScore(), s1.getRatingScore()));

        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);

            StudentTab studentByIdTab = new StudentTab(student);
            data[i][0] = i + 1;
            data[i][1] = new ShowButton(studentByIdTab);
            data[i][2] = student.getRatingScore();
        }

        JTable jt = new JTable(new JTableButtonModel(data, columns));
        jt.addMouseListener(new JTableButtonMouseListener(jt));

        TableCellRenderer tableRenderer = jt.getDefaultRenderer(JButton.class);
        jt.setDefaultRenderer(JButton.class, new JTableButtonRenderer(tableRenderer));
        jt.setPreferredScrollableViewportSize(STUDENTS_TABLE_DIMENSION);
        jt.setFillsViewportHeight(true);
        return new JScrollPane(jt);
    }
}

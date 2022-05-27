package org.example.service.gui.extension;

import org.example.model.Student;
import org.example.service.gui.extension.button.SelectUserByIdJButton;
import org.example.service.gui.extension.table.JTableButtonModel;
import org.example.service.gui.extension.table.JTableButtonRenderer;
import org.example.service.gui.tab.StudentByIdTab;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class StudentsTableFrameExtension implements FrameExtension {

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

            data[i][0] = new SelectUserByIdJButton(studentByIdTab);
            data[i][1] = student.getId();
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
        jt.setBounds(30, 40, 200, 300);

        return new JScrollPane(jt);
    }

    private static class JTableButtonMouseListener extends MouseAdapter {
        private final JTable table;

        public JTableButtonMouseListener(JTable table) {
            this.table = table;
        }

        public void mouseClicked(MouseEvent e) {
            int column = table.getColumnModel().getColumnIndexAtX(e.getX()); // get the coloum of the button
            int row    = e.getY()/table.getRowHeight(); //get the row of the button

            /*Checking the row or column is valid or not*/
            if (row < table.getRowCount() && row >= 0 && column < table.getColumnCount() && column >= 0) {
                Object value = table.getValueAt(row, column);
                if (value instanceof JButton) {
                    /*perform a click event*/
                    ((JButton)value).doClick();
                }
            }
        }
    }


}

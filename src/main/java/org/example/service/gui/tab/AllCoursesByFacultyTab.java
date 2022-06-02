package org.example.service.gui.tab;

import org.example.model.Faculty;
import org.example.model.Group;
import org.example.service.db.dao.GroupDatabaseHelper;
import org.example.service.gui.extension.button.ShowButton;
import org.example.service.gui.extension.table.util.JTableButtonModel;
import org.example.service.gui.extension.table.util.JTableButtonMouseListener;
import org.example.service.gui.extension.table.util.JTableButtonRenderer;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.List;

public class AllCoursesByFacultyTab implements FrameTab {

    private static final int TABLE_X = 30;
    private static final int TABLE_Y = 40;
    private static final int TABLE_WIDTH = 800;
    private static final int TABLE_HEIGHT = 500;

    private final Faculty faculty;
    private final GroupDatabaseHelper groupDatabaseHelper;

    public AllCoursesByFacultyTab(Faculty faculty) {
        this.faculty = faculty;
        this.groupDatabaseHelper = new GroupDatabaseHelper();
    }

    @Override
    public String title() {
        return faculty.getName() + "-courses";
    }

    @Override
    public List<Component> components() {
        String[] columns = {"action", "course"};

        List<Integer> allDistinctCoursesByFacultyName = groupDatabaseHelper.findAllDistinctCoursesByFacultyName(faculty.getName());

        Object[][] data = new Object[allDistinctCoursesByFacultyName.size()][columns.length];

        for (int i = 0; i < allDistinctCoursesByFacultyName.size(); i++) {
            int course = allDistinctCoursesByFacultyName.get(i);
            AllStudentsByGroupNameTab groupByIdTab = new AllStudentsByGroupNameTab(null);
            data[i][0] = new ShowButton(groupByIdTab);
        }

        JTable jt = new JTable(new JTableButtonModel(data, columns));
        jt.addMouseListener(new JTableButtonMouseListener(jt));

        TableCellRenderer tableRenderer = jt.getDefaultRenderer(JButton.class);
        jt.setDefaultRenderer(JButton.class, new JTableButtonRenderer(tableRenderer));
        jt.setBounds(TABLE_X, TABLE_Y, TABLE_WIDTH, TABLE_HEIGHT);

        return null;
    }

}

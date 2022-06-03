package org.example.service.gui.tab;

import org.example.model.Faculty;
import org.example.service.db.dao.GroupDatabaseHelper;
import org.example.service.gui.extension.button.ShowButton;
import org.example.service.gui.extension.table.util.JTableButtonModel;
import org.example.service.gui.extension.table.util.JTableButtonMouseListener;
import org.example.service.gui.extension.table.util.JTableButtonRenderer;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.List;

/**
 * Frame tab which shows all the active courses which {@link Faculty} contains
 */
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
        return faculty.getName();
    }

    @Override
    public List<Component> components() {
        String[] columns = {"course"};

        List<Integer> allDistinctCoursesByFacultyName = groupDatabaseHelper.findAllDistinctCoursesByFacultyName(faculty.getName());

        Object[][] data = new Object[allDistinctCoursesByFacultyName.size()][columns.length];
        allDistinctCoursesByFacultyName.sort(Integer::compare);

        for (int i = 0; i < allDistinctCoursesByFacultyName.size(); i++) {
            int course = allDistinctCoursesByFacultyName.get(i);
            data[i][0] = new ShowButton(new AllGroupsByFacultyNameAndCourseTab(faculty, course), String.valueOf(course));
        }

        JTable jt = new JTable(new JTableButtonModel(data, columns));
        jt.addMouseListener(new JTableButtonMouseListener(jt));

        TableCellRenderer tableRenderer = jt.getDefaultRenderer(JButton.class);
        jt.setDefaultRenderer(JButton.class, new JTableButtonRenderer(tableRenderer));
        jt.setBounds(TABLE_X, TABLE_Y, TABLE_WIDTH, TABLE_HEIGHT);

        return List.of(new JScrollPane(jt));
    }

}

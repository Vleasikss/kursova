package org.example.service.gui.extension.table;

import org.example.model.Group;
import org.example.service.gui.extension.FrameExtension;
import org.example.service.gui.extension.button.ShowButton;
import org.example.service.gui.extension.table.util.JTableButtonModel;
import org.example.service.gui.extension.table.util.JTableButtonMouseListener;
import org.example.service.gui.extension.table.util.JTableButtonRenderer;
import org.example.service.gui.tab.AllStudentsByGroupNameTab;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.List;

public class GroupsTableFrameExtension implements FrameExtension {

    private static final int TABLE_X = 30;
    private static final int TABLE_Y = 40;
    private static final int TABLE_WIDTH = 800;
    private static final int TABLE_HEIGHT = 500;

    private final List<Group> groups;

    public GroupsTableFrameExtension(List<Group> faculties) {
        this.groups = faculties;
    }

    @Override
    public Component apply() {
        String[] columns = {"group"};
        Object[][] data = new Object[groups.size()][columns.length];

        for (int i = 0; i < groups.size(); i++) {
            Group group = groups.get(i);
            AllStudentsByGroupNameTab groupByIdTab = new AllStudentsByGroupNameTab(group);
            data[i][0] = new ShowButton(groupByIdTab);
        }

        JTable jt = new JTable(new JTableButtonModel(data, columns));
        jt.addMouseListener(new JTableButtonMouseListener(jt));

        TableCellRenderer tableRenderer = jt.getDefaultRenderer(JButton.class);
        jt.setDefaultRenderer(JButton.class, new JTableButtonRenderer(tableRenderer));
        jt.setBounds(TABLE_X, TABLE_Y, TABLE_WIDTH, TABLE_HEIGHT);

        return new JScrollPane(jt);
    }
}

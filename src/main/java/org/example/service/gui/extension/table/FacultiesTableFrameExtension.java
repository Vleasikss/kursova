package org.example.service.gui.extension.table;

import org.example.model.Faculty;
import org.example.service.gui.extension.FrameExtension;
import org.example.service.gui.extension.button.ShowButton;
import org.example.service.gui.extension.table.util.JTableButtonModel;
import org.example.service.gui.extension.table.util.JTableButtonMouseListener;
import org.example.service.gui.extension.table.util.JTableButtonRenderer;
import org.example.service.gui.tab.AllGroupsByFacultyNameTab;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.List;

public class FacultiesTableFrameExtension implements FrameExtension {

    private static final int TABLE_X = 30;
    private static final int TABLE_Y = 40;
    private static final int TABLE_WIDTH = 200;
    private static final int TABLE_HEIGHT = 300;

    private final List<Faculty> faculties;

    public FacultiesTableFrameExtension(List<Faculty> faculties) {
        this.faculties = faculties;
    }

    @Override
    public Component apply() {
        String[] columns = {"faculty"};
        Object[][] data = new Object[faculties.size()][columns.length];

        for (int i = 0; i < faculties.size(); i++) {
            Faculty faculty = faculties.get(i);
            AllGroupsByFacultyNameTab facultyByIdTab = new AllGroupsByFacultyNameTab(faculty);
            data[i][0] = new ShowButton(facultyByIdTab);
        }

        JTable jt = new JTable(new JTableButtonModel(data, columns));
        jt.addMouseListener(new JTableButtonMouseListener(jt));

        TableCellRenderer tableRenderer = jt.getDefaultRenderer(JButton.class);
        jt.setDefaultRenderer(JButton.class, new JTableButtonRenderer(tableRenderer));
        jt.setBounds(TABLE_X, TABLE_Y, TABLE_WIDTH, TABLE_HEIGHT);

        return new JScrollPane(jt);
    }
}

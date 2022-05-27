package org.example.service.gui.extension.table;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JTableButtonModel extends AbstractTableModel {

    private final Object[][] rows;
    private final String[] columns;

    public JTableButtonModel(Object[][] rows, String[] columns) {
        this.columns = columns;
        this.rows = rows;
    }

    public String getColumnName(int column) {
        return columns[column];
    }

    public int getRowCount() {
        return rows.length;
    }

    public int getColumnCount() {
        return columns.length;
    }

    public Object getValueAt(int row, int column) {
        return rows[row][column];
    }

    public boolean isCellEditable(int row, int column) {
        return false;
    }

    public Class<?> getColumnClass(int column) {
        return getValueAt(0, column).getClass();
    }

}

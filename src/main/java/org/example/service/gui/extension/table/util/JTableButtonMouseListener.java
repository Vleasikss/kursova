package org.example.service.gui.extension.table.util;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * {@link MouseEvent} listener which uses to apply click actions for the {@link JButton} inside {@link JTable}
 */
public class JTableButtonMouseListener extends MouseAdapter {

    private final JTable table;

    public JTableButtonMouseListener(JTable table) {
        this.table = table;
    }

    /**
     * Applies a click action for the {@link JButton} inside {@link JTable}
     *
     * @param e some mouse event
     */
    public void mouseClicked(MouseEvent e) {
        int column = table.getColumnModel().getColumnIndexAtX(e.getX());
        int rowButton = e.getY() / table.getRowHeight();

        if (isRowValid(rowButton) && isColumnValid(column)) {
            Object value = table.getValueAt(rowButton, column);
            if (value instanceof JButton) {
                ((JButton) value).doClick();
            }
        }
    }

    private boolean isRowValid(int rowButton) {
        return rowButton < table.getRowCount() && rowButton >= 0;
    }

    private boolean isColumnValid(int column) {
        return column < table.getColumnCount() && column >= 0;
    }

}

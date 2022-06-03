package org.example.service.gui.extension.table.util;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

/**
 * extension of {@link TableCellRenderer} but with correct {@link Component} rendering
 */
public class JTableButtonRenderer implements TableCellRenderer {

    private final TableCellRenderer defaultRenderer;

    public JTableButtonRenderer(TableCellRenderer renderer) {
        defaultRenderer = renderer;
    }

    /**
     * extension of {@link TableCellRenderer#getTableCellRendererComponent(JTable, Object, boolean, boolean, int, int)} but with correct {@link Component} rendering
     */
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (value instanceof Component) {
            return (Component) value;
        }
        return defaultRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }

}
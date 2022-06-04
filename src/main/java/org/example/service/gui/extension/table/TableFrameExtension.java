package org.example.service.gui.extension.table;

import org.example.service.gui.extension.FrameExtension;
import org.example.service.gui.extension.table.converter.TableConverter;
import org.example.service.gui.extension.table.util.JTableButtonModel;
import org.example.service.gui.extension.table.util.JTableButtonMouseListener;
import org.example.service.gui.extension.table.util.JTableButtonRenderer;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.List;

/**
 * Abstraction over {@link FrameExtension} to work with {@link JTable} in more declarative way
 *
 * @param <T> Model Type to show in {@link JTable}
 */
public abstract class TableFrameExtension<T> implements FrameExtension {

    private static final Dimension DEFAULT_TABLE_DIMENSION = new Dimension(700, 800);

    private final TableConverter<T> converter;
    private final List<T> models;
    private final Dimension size;

    public TableFrameExtension(TableConverter<T> t, List<T> models) {
        this.converter = t;
        this.models = models;
        this.size = DEFAULT_TABLE_DIMENSION;
    }

    public TableFrameExtension(TableConverter<T> t, List<T> models, Dimension size) {
        this.converter = t;
        this.models = models;
        this.size = size;
    }

    @Override
    public Component apply() {
        Object[][] data = converter.convert(models);
        JTable jt = new JTable(new JTableButtonModel(data, converter.columns()));
        jt.addMouseListener(new JTableButtonMouseListener(jt));

        TableCellRenderer tableRenderer = jt.getDefaultRenderer(JButton.class);
        jt.setDefaultRenderer(JButton.class, new JTableButtonRenderer(tableRenderer));
        jt.setPreferredScrollableViewportSize(size);
        jt.setFillsViewportHeight(true);
        return new JScrollPane(jt);
    }

}

package org.example.service.gui.extension.table.converter;

import java.util.List;

/**
 * ({@link TableConverter#columns()}, {@link T}) to dimensional array converter for a {@link javax.swing.JTable} mapping
 *
 * @param <T> Model
 */
public interface TableConverter<T> {

    /**
     * @return columns of JTable
     */
    String[] columns();

    /**
     * @param ts List of {@link T} to convert
     * @return rows of JTable
     */
    Object[][] convert(List<T> ts);

}

package org.example.service.gui.extension.table.converter;

import java.util.List;

/**
 * ({@link TableConverter#columns()}, {@link T}) to dimensional array converter for a {@link javax.swing.JTable} mapping
 * @param <T> Model
 */
public interface TableConverter<T> {

    String[] columns();

    Object[][] convert(List<T> t);

}

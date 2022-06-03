package org.example.service.gui.extension.table.converter;

import java.util.List;

public interface TableConverter<T> {

    String[] columns();

    Object[][] convert(List<T> t);

}

package org.example.service.gui.extension.table.converter;

import org.example.model.Faculty;
import org.example.service.gui.extension.button.ShowButton;
import org.example.service.gui.tab.AllCoursesByFacultyTab;

import java.util.List;

public class FacultiesTableConverter implements TableConverter<Faculty> {

    @Override
    public String[] columns() {
        return new String[]{"faculty"};
    }

    @Override
    public Object[][] convert(List<Faculty> faculties) {
        Object[][] data = new Object[faculties.size()][columns().length];

        for (int i = 0; i < faculties.size(); i++) {
            Faculty faculty = faculties.get(i);
            AllCoursesByFacultyTab allCoursesByFacultyTab = new AllCoursesByFacultyTab(faculty);
            data[i][0] = new ShowButton(allCoursesByFacultyTab);
        }

        return data;
    }

}

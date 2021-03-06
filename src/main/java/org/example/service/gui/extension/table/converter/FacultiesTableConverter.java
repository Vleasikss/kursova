package org.example.service.gui.extension.table.converter;

import org.example.model.Faculty;
import org.example.service.gui.extension.button.ShowButton;
import org.example.service.gui.tab.AllCoursesByFacultyTab;

import java.util.List;

/**
 * realization of {@link TableConverter} which converts {@link Faculty} into dimensional array with required {@link FacultiesTableConverter#columns()}
 **/
public class FacultiesTableConverter implements TableConverter<Faculty> {

    @Override
    public String[] columns() {
        return new String[]{"faculty"};
    }

    @Override
    public Object[][] convert(List<Faculty> ts) {
        Object[][] data = new Object[ts.size()][columns().length];

        for (int i = 0; i < ts.size(); i++) {
            Faculty faculty = ts.get(i);
            AllCoursesByFacultyTab allCoursesByFacultyTab = new AllCoursesByFacultyTab(faculty);
            data[i][0] = new ShowButton(allCoursesByFacultyTab);
        }

        return data;
    }

}

package org.example.service.gui.extension.table.converter;

import org.example.model.Student;
import org.example.service.gui.extension.button.ShowButton;
import org.example.service.gui.tab.StudentTab;

import java.util.List;

/**
 * realization of {@link TableConverter} which converts {@link Student} into dimensional array with required {@link StudentsRatingScoreConverter#columns()}
 */
public class StudentsRatingScoreConverter implements TableConverter<Student> {

    @Override
    public String[] columns() {
        return new String[]{"id", "student", "ratingScore"};
    }

    @Override
    public Object[][] convert(List<Student> ts) {
        Object[][] data = new Object[ts.size()][columns().length];

        for (int i = 0; i < ts.size(); i++) {
            Student student = ts.get(i);

            StudentTab studentByIdTab = new StudentTab(student);
            data[i][0] = i + 1;
            data[i][1] = new ShowButton(studentByIdTab);
            data[i][2] = student.getRatingScore();
        }

        return data;
    }

}

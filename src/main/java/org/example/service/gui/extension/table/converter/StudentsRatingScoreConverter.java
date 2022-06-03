package org.example.service.gui.extension.table.converter;

import org.example.model.Student;
import org.example.service.gui.extension.button.ShowButton;
import org.example.service.gui.tab.StudentTab;

import java.util.List;

public class StudentsRatingScoreConverter implements TableConverter<Student> {

    @Override
    public String[] columns() {
        return new String[]{"id", "student", "ratingScore"};
    }

    @Override
    public Object[][] convert(List<Student> students) {
        Object[][] data = new Object[students.size()][columns().length];

        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);

            StudentTab studentByIdTab = new StudentTab(student);
            data[i][0] = i + 1;
            data[i][1] = new ShowButton(studentByIdTab);
            data[i][2] = student.getRatingScore();
        }

        return data;
    }
}

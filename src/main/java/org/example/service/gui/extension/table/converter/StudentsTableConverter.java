package org.example.service.gui.extension.table.converter;

import org.example.model.Student;
import org.example.service.gui.extension.button.DeleteActions;
import org.example.service.gui.extension.button.DeleteModelButton;
import org.example.service.gui.extension.button.ShowButton;
import org.example.service.gui.tab.FrameTab;
import org.example.service.gui.tab.StudentTab;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * realization of {@link TableConverter} which converts {@link Student} into dimensional array with required {@link StudentsRatingScoreConverter#columns()}
 */
public class StudentsTableConverter implements TableConverter<Student> {

    private final FrameTab openedTab;

    public StudentsTableConverter(FrameTab openedTab) {
        this.openedTab = openedTab;
    }

    @Override
    public String[] columns() {
        return new String[]{"info", "id", "firstName", "lastName", "patronymic", "form", "groupId", "facultyId", "course", "delete"};
    }

    @Override
    public Object[][] convert(List<Student> ts) {
        Object[][] data = new Object[ts.size()][columns().length];

        for (int i = 0; i < ts.size(); i++) {
            Student student = ts.get(i);

            StudentTab studentByIdTab = new StudentTab(student);

            data[i][0] = new ShowButton(studentByIdTab);
            data[i][1] = i + 1;
            data[i][2] = student.getFirstName();
            data[i][3] = student.getLastName();
            data[i][4] = student.getPatronymic();
            data[i][5] = student.getForm();
            data[i][6] = student.getGroupId();
            data[i][7] = student.getFacultyId();
            data[i][8] = extractCourseFromGroupName(student.getGroupId());
            data[i][9] = new DeleteModelButton<>(openedTab, student, DeleteActions.DELETE_STUDENT_BY_ID_ACTION);
        }

        return data;
    }

    private static int extractCourseFromGroupName(String groupId) {
        Pattern pattern = Pattern.compile("-.*");
        Matcher matcher = pattern.matcher(groupId);
        if (matcher.find()) {
            String after = matcher.group();
            return Integer.parseInt(String.valueOf(after.toCharArray()[1]));
        }
        return -1;
    }

}

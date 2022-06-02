package org.example.service.gui.tab;

import org.example.service.db.dao.StudentDatabaseHelper;
import org.example.service.gui.extension.button.ShowButton;
import org.example.service.gui.extension.table.StudentsTableFrameExtension;

import java.awt.*;
import java.util.List;

public class AllStudentsTab implements FrameTab {

    private static final String ALL_STUDENTS_TAB_TITLE = "all-students";
    private static AllStudentsTab allStudentsTab;

    private final StudentDatabaseHelper studentDatabaseHelper;

    private AllStudentsTab() {
        this.studentDatabaseHelper = new StudentDatabaseHelper();
    }

    public static AllStudentsTab getInstance() {
        if (allStudentsTab == null) {
            allStudentsTab = new AllStudentsTab();
        }
        return allStudentsTab;
    }

    @Override
    public String title() {
        return ALL_STUDENTS_TAB_TITLE;
    }

    @Override
    public List<Component> components() {
        return List.of(
                new StudentsTableFrameExtension(studentDatabaseHelper.findAll()).apply(),
                new ShowButton(new AddStudentTab())
        );
    }

}

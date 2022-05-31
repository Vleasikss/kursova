package org.example.service.gui.tab;

import org.example.service.db.dao.StudentDatabaseHelper;
import org.example.service.gui.extension.table.StudentsTableFrameExtension;

import java.awt.*;

public class AllStudentsTab implements FrameTab {

    private static final String ALL_STUDENTS_TAB_TITLE = "all students";

    private final StudentDatabaseHelper studentDatabaseHelper;
    
    public AllStudentsTab() {
        this.studentDatabaseHelper = new StudentDatabaseHelper();
    }

    @Override
    public String title() {
        return ALL_STUDENTS_TAB_TITLE;
    }

    @Override
    public Component apply() {
        return new StudentsTableFrameExtension(studentDatabaseHelper.findAll()).apply();
    }

}

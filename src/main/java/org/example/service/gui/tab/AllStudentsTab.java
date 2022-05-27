package org.example.service.gui.tab;

import org.example.service.db.dao.StudentDatabaseHelper;
import org.example.service.gui.extension.StudentsTableFrameExtension;

import java.awt.*;

public class AllStudentsTab implements FrameTab {

    private final StudentDatabaseHelper studentDatabaseHelper;

    public AllStudentsTab() {
        this.studentDatabaseHelper = new StudentDatabaseHelper();
    }


    @Override
    public String title() {
        return "all students";
    }

    @Override
    public Component apply() {
        return new StudentsTableFrameExtension(studentDatabaseHelper.findAll()).apply();
    }

}

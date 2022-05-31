package org.example.service.gui.tab;

import org.example.service.db.dao.FacultyDatabaseHelper;
import org.example.service.gui.extension.table.FacultiesTableFrameExtension;

import java.awt.*;

public class AllFacultiesTab implements FrameTab {

    private final FacultyDatabaseHelper facultyDatabaseHelper;

    public AllFacultiesTab() {
        this.facultyDatabaseHelper = new FacultyDatabaseHelper();
    }

    @Override
    public String title() {
        return "all faculties";
    }

    @Override
    public Component apply() {
        return new FacultiesTableFrameExtension(facultyDatabaseHelper.findAll()).apply();
    }

}

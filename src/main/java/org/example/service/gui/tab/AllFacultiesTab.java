package org.example.service.gui.tab;

import org.example.service.db.dao.FacultyDatabaseHelper;
import org.example.service.gui.extension.table.FacultiesTableFrameExtension;

import java.awt.*;
import java.util.List;

/**
 * Frame Tab which shows all the Faculties
 */
public class AllFacultiesTab implements FrameTab {

    private static final String ALL_FACULTIES_TAB_TITLE = "all-faculties";
    private static AllFacultiesTab allFacultiesTab;

    private final FacultyDatabaseHelper facultyDatabaseHelper;

    private AllFacultiesTab() {
        this.facultyDatabaseHelper = new FacultyDatabaseHelper();
    }

    public static AllFacultiesTab getInstance() {
        if (allFacultiesTab == null) {
            allFacultiesTab = new AllFacultiesTab();
        }
        return allFacultiesTab;
    }

    @Override
    public String title() {
        return ALL_FACULTIES_TAB_TITLE;
    }

    @Override
    public List<Component> components() {
        return List.of(new FacultiesTableFrameExtension(facultyDatabaseHelper.findAll()).apply());
    }

}

package org.example.service.gui.tab.id;

import org.example.model.Faculty;
import org.example.service.db.dao.GroupDatabaseHelper;
import org.example.service.gui.extension.table.GroupsTableFrameExtension;
import org.example.service.gui.tab.FrameTab;

import javax.swing.*;
import java.awt.*;

public class FacultyByIdTab implements FrameTab {

    private final Faculty faculty;
    private final GroupDatabaseHelper groupDatabaseHelper;

    public FacultyByIdTab(Faculty faculty) {
        this.faculty = faculty;
        this.groupDatabaseHelper = new GroupDatabaseHelper();
    }

    @Override
    public String title() {
        return faculty.getName();
    }

    @Override
    public Component apply() {
        return new GroupsTableFrameExtension(groupDatabaseHelper.findByFacultyName(faculty.getName())).apply();
    }

}

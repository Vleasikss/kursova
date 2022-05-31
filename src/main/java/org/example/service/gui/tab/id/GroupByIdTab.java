package org.example.service.gui.tab.id;

import org.example.model.Group;
import org.example.service.db.dao.StudentDatabaseHelper;
import org.example.service.gui.extension.table.StudentsTableFrameExtension;
import org.example.service.gui.tab.FrameTab;

import java.awt.*;

public class GroupByIdTab implements FrameTab {

    private final Group group;
    private final StudentDatabaseHelper studentDatabaseHelper;

    public GroupByIdTab(Group faculty) {
        this.group = faculty;
        this.studentDatabaseHelper = new StudentDatabaseHelper();
    }

    @Override
    public String title() {
        return group.getName();
    }

    @Override
    public Component apply() {
        return new StudentsTableFrameExtension(studentDatabaseHelper.findByGroupName(group.getName())).apply();
    }
}

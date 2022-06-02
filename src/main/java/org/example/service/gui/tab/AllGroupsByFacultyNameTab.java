package org.example.service.gui.tab;

import org.example.model.Faculty;
import org.example.service.db.dao.GroupDatabaseHelper;
import org.example.service.gui.extension.table.GroupsTableFrameExtension;

import java.awt.*;
import java.util.List;

public class AllGroupsByFacultyNameTab implements FrameTab {

    private final Faculty faculty;
    private final GroupDatabaseHelper groupDatabaseHelper;

    public AllGroupsByFacultyNameTab(Faculty faculty) {
        this.faculty = faculty;
        this.groupDatabaseHelper = new GroupDatabaseHelper();
    }

    @Override
    public String title() {
        return faculty.getName() + "-groups";
    }

    @Override
    public List<Component> components() {
        return List.of(
                new GroupsTableFrameExtension(groupDatabaseHelper.findByFacultyName(faculty.getName())).apply()
        );
    }

}

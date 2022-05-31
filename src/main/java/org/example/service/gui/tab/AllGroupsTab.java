package org.example.service.gui.tab;

import org.example.service.db.dao.FacultyDatabaseHelper;
import org.example.service.db.dao.GroupDatabaseHelper;
import org.example.service.gui.extension.table.FacultiesTableFrameExtension;
import org.example.service.gui.extension.table.GroupsTableFrameExtension;

import java.awt.*;

public class AllGroupsTab implements FrameTab {

    private final GroupDatabaseHelper groupDatabaseHelper;

    public AllGroupsTab() {
        this.groupDatabaseHelper = new GroupDatabaseHelper();
    }

    @Override
    public String title() {
        return "all groups";
    }

    @Override
    public Component apply() {
        return new GroupsTableFrameExtension(groupDatabaseHelper.findAll()).apply();
    }


}

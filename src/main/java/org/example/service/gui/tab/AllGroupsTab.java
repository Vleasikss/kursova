package org.example.service.gui.tab;

import org.example.service.db.dao.GroupDatabaseHelper;
import org.example.service.gui.extension.table.GroupsTableFrameExtension;

import java.awt.*;
import java.util.List;

public class AllGroupsTab implements FrameTab {

    private static final String ALL_GROUPS_TAB_TITLE = "groups";
    private static AllGroupsTab allGroupsTab;

    private final GroupDatabaseHelper groupDatabaseHelper;

    private AllGroupsTab() {
        this.groupDatabaseHelper = new GroupDatabaseHelper();
    }

    public static AllGroupsTab getInstance(){
        if (allGroupsTab == null) {
            allGroupsTab = new AllGroupsTab();
        }
        return allGroupsTab;
    }

    @Override
    public String title() {
        return ALL_GROUPS_TAB_TITLE;
    }

    @Override
    public List<Component> components() {
        return List.of(new GroupsTableFrameExtension(groupDatabaseHelper.findAll()).apply());
    }


}

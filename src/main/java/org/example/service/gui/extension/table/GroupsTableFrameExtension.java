package org.example.service.gui.extension.table;

import org.example.model.Group;
import org.example.service.gui.extension.table.converter.GroupsTableConverter;

import java.util.List;

public class GroupsTableFrameExtension extends TableFrameExtension<Group> {

    public GroupsTableFrameExtension(List<Group> groups) {
        super(new GroupsTableConverter(), groups);
    }

}

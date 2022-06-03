package org.example.service.gui.extension.table;

import org.example.model.Group;
import org.example.model.Student;
import org.example.service.gui.extension.table.converter.GroupsTableConverter;

import java.util.List;

/**
 * Realization of {@link TableFrameExtension} for showing a table of {@link Student} ordered by {@link Student#getRatingScore()}
 */
public class GroupsTableFrameExtension extends TableFrameExtension<Group> {

    public GroupsTableFrameExtension(List<Group> groups) {
        super(new GroupsTableConverter(), groups);
    }

}

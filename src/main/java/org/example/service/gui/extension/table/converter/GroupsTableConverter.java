package org.example.service.gui.extension.table.converter;

import org.example.model.Group;
import org.example.service.gui.extension.button.DeleteActions;
import org.example.service.gui.extension.button.DeleteModelButton;
import org.example.service.gui.extension.button.ShowButton;
import org.example.service.gui.tab.AllStudentsByGroupNameTab;
import org.example.service.gui.tab.FrameTab;

import java.util.List;

public class GroupsTableConverter implements TableConverter<Group> {


    public GroupsTableConverter() {
    }


    @Override
    public String[] columns() {
        return new String[] {"group"};
    }

    @Override
    public Object[][] convert(List<Group> groups) {
        Object[][] data = new Object[groups.size()][columns().length];

        for (int i = 0; i < groups.size(); i++) {
            Group group = groups.get(i);
            AllStudentsByGroupNameTab groupByIdTab = new AllStudentsByGroupNameTab(group);
            data[i][0] = new ShowButton(groupByIdTab);
        }

        return data;
    }

}

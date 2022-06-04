package org.example.service.gui.extension.table.converter;

import org.example.model.Group;
import org.example.service.gui.extension.button.ShowButton;
import org.example.service.gui.tab.AllStudentsByGroupNameTab;

import java.util.List;

/**
 * realization of {@link TableConverter} which converts {@link Group} into dimensional array with required {@link GroupsTableConverter#columns()}
 */
public class GroupsTableConverter implements TableConverter<Group> {

    @Override
    public String[] columns() {
        return new String[]{"group"};
    }

    @Override
    public Object[][] convert(List<Group> ts) {
        Object[][] data = new Object[ts.size()][columns().length];

        for (int i = 0; i < ts.size(); i++) {
            Group group = ts.get(i);
            AllStudentsByGroupNameTab groupByIdTab = new AllStudentsByGroupNameTab(group);
            data[i][0] = new ShowButton(groupByIdTab);
        }

        return data;
    }

}

package org.example.service.gui.tab;

import org.example.model.Group;
import org.example.service.db.dao.StudentDatabaseHelper;
import org.example.service.gui.extension.button.ShowButton;
import org.example.service.gui.extension.table.StudentsTableFrameExtension;

import java.awt.*;
import java.util.List;

/**
 * Frame Tab which shows all the students by {@link AllStudentsByGroupNameTab#group}
 */
public class AllStudentsByGroupNameTab implements FrameTab {

    private final Group group;
    private final StudentDatabaseHelper studentDatabaseHelper;

    public AllStudentsByGroupNameTab(Group group) {
        this.group = group;
        this.studentDatabaseHelper = new StudentDatabaseHelper();
    }

    @Override
    public String title() {
        return group.getName();
    }

    @Override
    public List<Component> components() {
        return List.of(
                new StudentsTableFrameExtension(studentDatabaseHelper.findByGroupName(group.getName()), this).apply(),
                new ShowButton(new StudentsRatingScoreByGroupTab(group, studentDatabaseHelper))
        );
    }

}

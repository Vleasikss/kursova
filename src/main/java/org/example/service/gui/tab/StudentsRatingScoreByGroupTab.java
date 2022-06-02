package org.example.service.gui.tab;

import org.example.model.Group;
import org.example.model.Student;
import org.example.service.db.dao.StudentDatabaseHelper;
import org.example.service.gui.extension.table.StudentsRatingScoreFrameExtension;

import java.awt.*;
import java.util.List;

public class StudentsRatingScoreByGroupTab implements FrameTab {

    private final Group group;
    private final StudentDatabaseHelper studentDatabaseHelper;

    public StudentsRatingScoreByGroupTab(Group group, StudentDatabaseHelper studentDatabaseHelper) {
        this.group = group;
        this.studentDatabaseHelper = studentDatabaseHelper;
    }

    @Override
    public String title() {
        return group.getName() + "-rating";
    }

    @Override
    public List<Component> components() {
        List<Student> byGroupName = studentDatabaseHelper.findByGroupName(group.getName());
        return List.of(
                new StudentsRatingScoreFrameExtension(byGroupName).apply()
        );
    }
}

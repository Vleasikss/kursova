package org.example.service.gui.tab;

import org.example.model.Faculty;
import org.example.model.Group;
import org.example.service.db.dao.GroupDatabaseHelper;
import org.example.service.gui.extension.table.GroupsTableFrameExtension;

import java.awt.*;
import java.util.List;

public class AllGroupsByFacultyNameAndCourseTab implements FrameTab {

    private final Faculty faculty;
    private final GroupDatabaseHelper groupDatabaseHelper;
    private final int course;

    public AllGroupsByFacultyNameAndCourseTab(Faculty faculty, int course) {
        this.faculty = faculty;
        this.groupDatabaseHelper = new GroupDatabaseHelper();
        this.course = course;
    }

    @Override
    public String title() {
        return faculty.getName() + "-" + course + "-groups";
    }

    @Override
    public List<Component> components() {
        List<Group> byFacultyNameAndCourse = groupDatabaseHelper.findByFacultyNameAndCourse(faculty.getName(), course);
        return List.of(
                new GroupsTableFrameExtension(byFacultyNameAndCourse).apply()
        );
    }

}

package org.example;

import org.example.model.Student;
import org.example.service.db.dao.StudentDatabaseHelper;
import org.example.service.gui.ApplicationFrame;
import org.example.service.gui.ApplicationTabbedPane;
import org.example.service.gui.tab.AllStudentsTab;
import org.example.service.gui.tab.FrameTab;

import javax.swing.*;
import java.util.List;

public class Main1 {

    private static final ApplicationFrame frame = new ApplicationFrame("application-title");
    private static final ApplicationTabbedPane pane = ApplicationTabbedPane.getInstance();
    private static final AllStudentsTab allStudentsTab = new AllStudentsTab();
    private static final List<FrameTab> FRAME_TABS = List.of(allStudentsTab);

    public static void main(String[] args) {
        frame.add(ApplicationTabbedPane.getInstance());
        StudentDatabaseHelper studentDatabaseHelper = new StudentDatabaseHelper();

        List<Student> all = studentDatabaseHelper.findAll();
        String[] column = {"id", "firstName", "lastName", "patronymic", "form", "groupId", "facultyId", "ratingScore"};

        pane.removeAll();
        pane.addAll(FRAME_TABS);
        pane.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);

        frame.perform();

    }

}

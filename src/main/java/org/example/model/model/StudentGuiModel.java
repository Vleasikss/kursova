package org.example.model.model;

import org.example.model.Student;

public class StudentGuiModel extends Student implements GuiModel {

    @Override
    public String[] columns() {
        return new String[]{"id", "firstName", "lastName", "patronymic", "form", "groupId", "facultyId", "ratingScore"};
    }
}

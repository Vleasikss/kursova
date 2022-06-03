package org.example.service.gui.extension.button;

import org.example.model.Student;
import org.example.service.db.dao.StudentDatabaseHelper;

public final class DeleteActions {

    private static final StudentDatabaseHelper studentDatabaseHelper = new StudentDatabaseHelper();

    public static final DeleteAction<Student> DELETE_STUDENT_BY_ID_ACTION = (student) -> studentDatabaseHelper.deleteById(student.getId());

}

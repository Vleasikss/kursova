package org.example.service.gui.extension.table;

import org.example.model.Student;
import org.example.service.gui.extension.table.converter.StudentsTableConverter;
import org.example.service.gui.tab.FrameTab;

import java.awt.*;
import java.util.List;

public class StudentsTableFrameExtension extends TableFrameExtension<Student> {

    private static final Dimension STUDENTS_TABLE_FRAME_SIZE = new Dimension(1400, 800);

    public StudentsTableFrameExtension(List<Student> students, FrameTab frameTab) {
        super(new StudentsTableConverter(frameTab), students, STUDENTS_TABLE_FRAME_SIZE);
    }

}

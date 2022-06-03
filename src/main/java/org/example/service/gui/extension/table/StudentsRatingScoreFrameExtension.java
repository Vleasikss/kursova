package org.example.service.gui.extension.table;

import org.example.model.Student;
import org.example.service.gui.extension.table.converter.StudentsRatingScoreConverter;

import java.util.List;
import java.util.stream.Collectors;

public class StudentsRatingScoreFrameExtension extends TableFrameExtension<Student> {

    public StudentsRatingScoreFrameExtension(List<Student> students) {
        super(new StudentsRatingScoreConverter(),
                students.stream().sorted((s1, s2) -> Double.compare(s2.getRatingScore(), s1.getRatingScore())).collect(Collectors.toList()));
    }
}

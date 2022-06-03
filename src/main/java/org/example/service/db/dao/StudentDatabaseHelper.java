package org.example.service.db.dao;

import org.example.model.Faculty;
import org.example.model.Student;
import org.example.model.StudyForm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * JDBC DAO realization for a {@link Student}
 */
public class StudentDatabaseHelper implements DatabaseHelper<Student, Long> {

    //language=SQL
    private static final String FIND_ALL_STUDENTS_QUERY = "select * from STUDENT";
    //language=SQL
    private static final String INSERT_STUDENT_QUERY = "INSERT INTO STUDENT(first_name, last_name, patronymic, form, faculty_id, group_id, rating_score) VALUES (?, ?, ?, ?, ?, ?, ?)";
    //language=SQL
    private static final String DELETE_STUDENT_BY_ID_QUERY = "DELETE FROM STUDENT WHERE id = ?";
    //language=SQL
    private static final String FIND_STUDENTS_BY_GROUP_NAME_QUERY = "SELECT * FROM STUDENT where group_id = ?";
    //language=SQL
    private static final String FIND_STUDENTS_BY_GROUP_NAME_AND_STUDY_FORM_QUERY = "SELECT * FROM STUDENT where group_id = ? and form = ?";


    @Override
    public List<Student> findAll() {
        try {
            Connection connection = DatabaseConnector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_STUDENTS_QUERY);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Student> students = new ArrayList<>();

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String patronymic = resultSet.getString("patronymic");
                String form = resultSet.getString("form");
                double ratingScore = resultSet.getDouble("rating_score");
                String facultyId = resultSet.getString("faculty_id");
                String groupId = resultSet.getString("group_id");

                Student student = new Student();
                student.setId(id);
                student.setFirstName(firstName);
                student.setLastName(lastName);
                student.setPatronymic(patronymic);
                student.setForm(StudyForm.valueOf(form));
                student.setRatingScore(ratingScore);
                student.setFacultyId(facultyId);
                student.setGroupId(groupId);

                students.add(student);
            }

            connection.close();
            resultSet.close();
            preparedStatement.close();

            return students;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean insert(Student student) {
        try {
            Connection connection = DatabaseConnector.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT_QUERY);
            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setString(3, student.getPatronymic());
            preparedStatement.setString(4, student.getForm().name().toUpperCase());
            preparedStatement.setString(5, student.getFacultyId());
            preparedStatement.setString(6, student.getGroupId());
            preparedStatement.setDouble(7, student.getRatingScore());

            int countOfChanges = preparedStatement.executeUpdate();

            connection.close();
            preparedStatement.close();
            return countOfChanges == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteById(Long id) {
        try {
            Connection connection = DatabaseConnector.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUDENT_BY_ID_QUERY);
            preparedStatement.setLong(1, id);

            int countOfChanges = preparedStatement.executeUpdate();

            connection.close();
            preparedStatement.close();
            return countOfChanges == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Student> findByGroupName(String groupName) {
        try {
            Connection connection = DatabaseConnector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_STUDENTS_BY_GROUP_NAME_QUERY);
            preparedStatement.setString(1, groupName);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Student> students = new ArrayList<>();

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String patronymic = resultSet.getString("patronymic");
                String form = resultSet.getString("form");
                double ratingScore = resultSet.getDouble("rating_score");
                String facultyId = resultSet.getString("faculty_id");
                String groupId = resultSet.getString("group_id");

                Student student = new Student();
                student.setId(id);
                student.setFirstName(firstName);
                student.setLastName(lastName);
                student.setPatronymic(patronymic);
                student.setForm(StudyForm.valueOf(form));
                student.setRatingScore(ratingScore);
                student.setFacultyId(facultyId);
                student.setGroupId(groupId);

                students.add(student);
            }

            connection.close();
            resultSet.close();
            preparedStatement.close();

            return students;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;

        }
    }

    public List<Student> findByGroupNameAndStudyForm(String groupName, StudyForm studyForm) {
        try {
            Connection connection = DatabaseConnector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_STUDENTS_BY_GROUP_NAME_AND_STUDY_FORM_QUERY);
            preparedStatement.setString(1, groupName);
            preparedStatement.setString(2, studyForm.name());

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Student> students = new ArrayList<>();

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String patronymic = resultSet.getString("patronymic");
                String form = resultSet.getString("form");
                double ratingScore = resultSet.getDouble("rating_score");
                String facultyId = resultSet.getString("faculty_id");
                String groupId = resultSet.getString("group_id");

                Student student = new Student();
                student.setId(id);
                student.setFirstName(firstName);
                student.setLastName(lastName);
                student.setPatronymic(patronymic);
                student.setForm(StudyForm.valueOf(form));
                student.setRatingScore(ratingScore);
                student.setFacultyId(facultyId);
                student.setGroupId(groupId);

                students.add(student);
            }

            connection.close();
            resultSet.close();
            preparedStatement.close();

            return students;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;

        }
    }
}

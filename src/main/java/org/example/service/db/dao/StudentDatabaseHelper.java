package org.example.service.db.dao;

import org.example.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentDatabaseHelper implements DatabaseHelper<Student, Integer> {

    //language=SQL
    private static final String FIND_ALL_STUDENTS_QUERY = "select * from kursova_project_java.STUDENT";
    //language=SQL
    private static final String INSERT_STUDENT_QUERY = "INSERT INTO kursova_project_java.STUDENT VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    //language=SQL
    private static final String DELETE_STUDENT_BY_ID_QUERY = "DELETE FROM kursova_project_java.STUDENT WHERE id = ?";
    //language=SQL
    private static final String FIND_STUDENT_BY_ID_QUERY = "SELECT * FROM kursova_project_java.STUDENT WHERE id = ?";
    //language=SQL
    private static final String FIND_STUDENTS_BY_GROUP_NAME_QUERY = "SELECT * FROM kursova_project_java.STUDENT where group_id = ?";

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
                student.setForm(form);
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
            preparedStatement.setLong(1, student.getId());
            preparedStatement.setString(2, student.getFirstName());
            preparedStatement.setString(3, student.getLastName());
            preparedStatement.setString(4, student.getPatronymic());
            preparedStatement.setString(5, student.getForm());
            preparedStatement.setString(6, student.getFacultyId());
            preparedStatement.setString(7, student.getGroupId());
            preparedStatement.setDouble(8, student.getRatingScore());

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
    public boolean deleteById(Integer id) {
        try {
            Connection connection = DatabaseConnector.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUDENT_BY_ID_QUERY);
            preparedStatement.setInt(1, id);

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
    public Optional<Student> findById(Integer identifier) {
        try {
            Connection connection = DatabaseConnector.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(FIND_STUDENT_BY_ID_QUERY);
            preparedStatement.setMaxRows(1);
            preparedStatement.setInt(1, identifier);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                return Optional.empty();
            }

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
            student.setForm(form);
            student.setRatingScore(ratingScore);
            student.setFacultyId(facultyId);
            student.setGroupId(groupId);



            resultSet.close();
            preparedStatement.close();
            connection.close();

            return Optional.of(student);
        } catch (SQLException e) {
            e.printStackTrace();
            return Optional.empty();
        }

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
                student.setForm(form);
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

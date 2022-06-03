package org.example.service.db.dao;

import org.example.model.Group;
import org.example.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GroupDatabaseHelper implements DatabaseHelper<Group, String> {

    //language=sql
    private static final String FIND_GROUP_BY_FACULTY_NAME_QUERY = "SELECT * FROM `GROUP` where faculty_name = ?";
    //language=sql
    private static final String FIND_GROUPS_BY_FACULTY_NAME_AND_COURSE_QUERY = "SELECT * FROM `GROUP` where faculty_name = ? and course = ?";
    //language=sql
    private static final String FIND_ALL_GROUPS_QUERY = "SELECT * FROM `GROUP`";
    //language=SQL
    private static final String FIND_ALL_DISTINCT_COURSES_BY_FACULTY_NAME = "SELECT DISTINCT course as course FROM `GROUP` WHERE faculty_name = ?";
    //language=SQL
    private static final String DELETE_GROUP_BY_ID = "DELETE FROM `GROUP` WHERE group_name = ?";

    @Override
    public List<Group> findAll() {
        try {
            Connection connection = DatabaseConnector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_GROUPS_QUERY);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Group> groups = new ArrayList<>();

            while (resultSet.next()) {
                String groupName = resultSet.getString("group_name");
                String facultyName = resultSet.getString("faculty_name");
                int specialtyName = resultSet.getInt("speciality_name");
                int course = resultSet.getInt("course");

                Group group = new Group();
                group.setName(groupName);
                group.setFacultyName(facultyName);
                group.setSpecialtyName(specialtyName);
                group.setCourse(course);

                groups.add(group);
            }

            connection.close();
            resultSet.close();
            preparedStatement.close();

            return groups;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean insert(Group group) {
        return false;
    }

    @Override
    public boolean deleteById(String id) {
        try {
            Connection connection = DatabaseConnector.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_GROUP_BY_ID);
            preparedStatement.setString(1, id);

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
    public Optional<Student> findById(String s) {
        return Optional.empty();
    }

    public List<Group> findByFacultyName(String facultyName) {
        try {
            Connection connection = DatabaseConnector.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(FIND_GROUP_BY_FACULTY_NAME_QUERY);
            preparedStatement.setMaxRows(1);
            preparedStatement.setString(1, facultyName);

            ResultSet resultSet = preparedStatement.executeQuery();
            List<Group> groups = new ArrayList<>();
            while (resultSet.next()) {
                String groupName = resultSet.getString("group_name");
                String facultyName1 = resultSet.getString("faculty_name");
                int specialityName = resultSet.getInt("speciality_name");
                int course = resultSet.getInt("course");

                Group group = new Group();
                group.setName(groupName);
                group.setFacultyName(facultyName1);
                group.setSpecialtyName(specialityName);
                group.setCourse(course);
                groups.add(group);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();

            return groups;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Group> findByFacultyNameAndCourse(String facultyName, int course) {
        try {
            Connection connection = DatabaseConnector.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(FIND_GROUPS_BY_FACULTY_NAME_AND_COURSE_QUERY);
            preparedStatement.setString(1, facultyName);
            preparedStatement.setInt(2, course);

            ResultSet resultSet = preparedStatement.executeQuery();
            List<Group> groups = new ArrayList<>();
            while (resultSet.next()) {
                String groupName = resultSet.getString("group_name");
                int specialityName = resultSet.getInt("speciality_name");
                Group group = new Group();
                group.setName(groupName);
                group.setFacultyName(facultyName);
                group.setSpecialtyName(specialityName);
                group.setCourse(course);
                groups.add(group);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();

            return groups;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Integer> findAllDistinctCoursesByFacultyName(String facultyName) {
        try {
            Connection connection = DatabaseConnector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_DISTINCT_COURSES_BY_FACULTY_NAME);
            preparedStatement.setString(1, facultyName);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Integer> courses = new ArrayList<>();
            while (resultSet.next()) {
                int course = resultSet.getInt("course");
                courses.add(course);
            }

            connection.close();
            resultSet.close();
            preparedStatement.close();

            return courses;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

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

    //    todo
    @Override
    public List<Group> findAll() {
        return null;
    }

    //    todo
    @Override
    public boolean insert(Group group) {
        return false;
    }

    //    todo
    @Override
    public boolean deleteById(String s) {
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
            System.out.println(facultyName);
            preparedStatement.setMaxRows(1);
            preparedStatement.setString(1, facultyName);

            ResultSet resultSet = preparedStatement.executeQuery();
            List<Group> groups = new ArrayList<>();
            while (resultSet.next()) {
                String groupName = resultSet.getString("group_name");
                String facultyName1 = resultSet.getString("faculty_name");
                int speciality_name = resultSet.getInt("speciality_name");
                int course = resultSet.getInt("course");

                Group group = new Group();
                group.setName(groupName);
                group.setFacultyName(facultyName1);
                group.setSpecialtyName(speciality_name);
                group.setCourse(course);
                groups.add(group);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
            System.out.println(groups);
            return groups;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
}

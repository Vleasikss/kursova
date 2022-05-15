package org.example.service.dao;

import org.example.DatabaseConnector;
import org.example.model.Faculty;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacultyDatabaseHelper implements DatabaseHelper<Faculty, String> {

    //language=SQL
    private static final String FIND_ALL_FACULTIES_QUERY = "select * from kursova_project_java.FACULTY";

    @Override
    public List<Faculty> findAll() {
        try {
            Connection connection = DatabaseConnector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_FACULTIES_QUERY);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Faculty> faculties = new ArrayList<>();

            while (resultSet.next()) {
                String name = resultSet.getString("faculty_name");
                Faculty faculty = new Faculty();
                faculty.setName(name);

                faculties.add(faculty);
            }

            connection.close();
            resultSet.close();
            preparedStatement.close();

            return faculties;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean insert(Faculty faculty) {
//        todo
        return false;
    }

    @Override
    public boolean deleteById(String s) {
//        todo
        return false;
    }

}

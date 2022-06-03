package org.example.service.db.dao;

import org.example.model.Faculty;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * JDBC DAO realization for a {@link Faculty}
 */
public class FacultyDatabaseHelper implements DatabaseHelper<Faculty, String> {

    //language=SQL
    private static final String FIND_ALL_FACULTIES_QUERY = "SELECT * FROM FACULTY";

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


    /**
     * Not usable in the project so ignored
     */
    @Override
    public boolean insert(Faculty faculty) {
        return false;
    }

    /**
     * Not usable in the project so ignored
     */
    @Override
    public boolean deleteById(String s) {
        return false;
    }

}

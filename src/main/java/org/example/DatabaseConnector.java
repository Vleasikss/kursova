package org.example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public final class DatabaseConnector {

    private static final Properties properties;

    static {
        properties = new Properties();
        try {
            properties.load(DatabaseConnector.class.getResourceAsStream("/application.properties"));
        } catch (IOException e) {
            throw new RuntimeException("Unable to read properties from application.properties");
        }
    }

    private static final String JDBC_USERNAME = properties.getProperty("db.username");
    private static final String JDBC_PASSWORD = properties.getProperty("db.password");
    private static final String JDBC_DATABASE_NAME = properties.getProperty("db.database.name");
    private static final String JDBC_HOST = properties.getProperty("db.host");
    private static final String JDBC_PORT = properties.getProperty("db.port");
    private static final String JDBC_DRIVER = properties.getProperty("db.driver");

    private static final String JDBC_URL = "jdbc:" + JDBC_DRIVER + "://" + JDBC_HOST + ":" + JDBC_PORT + "/" + JDBC_DATABASE_NAME;

    private DatabaseConnector() {

    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Unable to create connection for " + JDBC_URL);
        }
    }

}

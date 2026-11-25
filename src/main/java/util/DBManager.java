package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
    // Connection information for shopdb
    private static final String URL = "jdbc:mysql://localhost:3306/shopdb";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    // Return a connection to the database
    public static Connection getConnection() throws SQLException {
        try {
            // Load the JDBC driver (needed in a web application)
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("JDBC driver not found.", e);
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

package jm.task.core.jdbc.util;

import java.sql.*;

public class Util {
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";
    private static final String DB_DBNAME = "mydbtest";
    private static final String DB_TABLE = "users";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/" + DB_DBNAME + "?user=" + DB_USER + "&password=" + DB_PASSWORD + "&serverTimezone=UTC";


    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM " + DB_TABLE);

            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + " " + resultSet.getString("name"));
            }
        } catch (
                SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            System.out.println("Error getConnection: " + e.getMessage());
        }
        return connection;
    }
}

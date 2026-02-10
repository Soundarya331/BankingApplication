package com.collections.library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    public static Connection getConnection() {

        String url = "jdbc:postgresql://localhost:5432/test";
        String username = "postgres";
        String password = "mypassword123";
        Connection connection = null;
        try {
             connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.err.println("Connection failed");
            System.err.println(e.getMessage());
        }
        return connection;
    }
}

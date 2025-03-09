package com.hyperskill;

import java.sql.*;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/football_stats";
    private static final String USERNAME = "amargolina";
    private static final String PASSWORD = "1111";


    private static Connection connection;

    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database.");
            e.printStackTrace();
            return null;
        }
    }
}


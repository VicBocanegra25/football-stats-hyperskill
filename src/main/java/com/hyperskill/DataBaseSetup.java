package com.hyperskill;

import java.sql.*;

public class DataBaseSetup {
    private static final String DB_NAME = "football_stats";

    public static void createDatabase() {
        // Try-with-resources will automatically close the resources when done
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement()) {

            // Check if the database exists
            String checkDbQuery = "SHOW DATABASES LIKE '" + DB_NAME + "';";
            try (ResultSet resultSet = statement.executeQuery(checkDbQuery)) {
                if (!resultSet.next()) {
                    // If the database does not exist, create it
                    String createDbQuery = "CREATE DATABASE " + DB_NAME;
                    statement.executeUpdate(createDbQuery);
                    System.out.println("Database '" + DB_NAME + "' created successfully.");
                } else {
                    System.out.println("Database '" + DB_NAME + "' already exists.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void setupTables() {
        String createTableTeams = """
            CREATE TABLE IF NOT EXISTS teams (
                id INT AUTO_INCREMENT PRIMARY KEY,
                team_name VARCHAR(255) NOT NULL
            );
        """;

        String createTablePlayers = """
            CREATE TABLE IF NOT EXISTS players (
                id INT AUTO_INCREMENT PRIMARY KEY,
                first_name VARCHAR(255) NOT NULL,
                last_name VARCHAR(255) NOT NULL,
                team_id INT,
                goals INT DEFAULT 0,
                FOREIGN KEY (team_id) REFERENCES teams(id)
                ON UPDATE CASCADE
            );
        """;

        String createTableCoaches = """
            CREATE TABLE IF NOT EXISTS coaches (
                id INT AUTO_INCREMENT PRIMARY KEY,
                first_name VARCHAR(255) NOT NULL,
                last_name VARCHAR(255) NOT NULL,
                team_id INT NOT NULL,
                FOREIGN KEY (team_id) REFERENCES teams(id)
                ON UPDATE CASCADE
            );
        """;

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(createTableTeams);
            stmt.execute(createTablePlayers);
            stmt.execute(createTableCoaches);
            System.out.println("Database setup completed.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

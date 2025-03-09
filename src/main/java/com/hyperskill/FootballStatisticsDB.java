package com.hyperskill;

import com.hyperskill.data_models.Player;
import com.hyperskill.data_models.Team;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FootballStatisticsDB {

    // Create
    public void addPlayer(Player player) {
        String query = "INSERT INTO players (first_name, last_name, team, goals) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, player.getFirstName());
            stmt.setString(2, player.getLastName());
            stmt.setString(3, player.getTeam().toString());
            stmt.setInt(4, player.getGoals());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Read
    public Player getPlayer(int id) {
        String query = "SELECT * FROM players WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Player(rs.getInt("id"),
                                    rs.getString("first_name"),
                                    rs.getString("last_name"),
                                    new Team(rs.getInt("id")),
                                    rs.getInt("goals"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Update
    public void updatePlayerGoals(int id, int goals) {
        String query = "UPDATE players SET goals = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, goals);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete
    public void deletePlayer(int id) {
        String query = "DELETE FROM players WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

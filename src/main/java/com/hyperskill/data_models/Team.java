package com.hyperskill.data_models;

import java.util.List;

/**
 * Team
 * <p>
 * Attributes: String name, List players, Coach coach
 * Methods: display/update stats (percentage of wins/losses/draws by year
 * /total, average/total goal score by year, total wins/losses/draws, etc.)
 */

public class Team {
    private int id;
    private String name;
    private List<Player> players;
    private Coach coach;
    private int wins = 0;
    private int losses = 0;
    private int draws = 0;

    public Team(){}

    public Team(int id, String name, List<Player> playersTeam, Coach coach) {
        this.id = id;
        this.name = name;
        players = playersTeam;
        coach = coach;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "Team {" +
                "id=" + id +
                ", name=" + name +
                "}";
    }

    public void displayStats() {
    }

    public void updateStats() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coach getCoach() {
        return coach;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public int getDraws() {
        return draws;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void win() {
        wins++;
    }

    public void lose() {
        losses++;
    }

    public void draw() {
        draws++;
    }

}

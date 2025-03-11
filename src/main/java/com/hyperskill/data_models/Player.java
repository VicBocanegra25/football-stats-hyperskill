package com.hyperskill.data_models;

/**
 * Player (base abstract class: Person)
 * <p>
 * Attributes: String firstName, String lastName, String team
 * Methods: display/update stats (goals scored, matches played, average goals scored, etc.) by year and total, etc.
 */

public class Player extends Person {
    private int id;
    private Team team;
    private int goals;
    private int matchesPlayed;

    public Player(){}

    public Player(int id, String firstName, String lastName, Team team, int goals) {
        super(firstName, lastName);
        this.id = id;
        this.team = team;
        this.goals = goals;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return super.getFirstName();
    }

    public String getLastName() {
        return super.getLastname();
    }

    public Team getTeam() {
        return team;
    }

    public int getGoals() {
        return goals;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void addGoals(int goals) {
        this.goals += goals;
    }

    @Override
    public String toString() {
        return "Player {" +
                "id = " + id +
                ", firstName = " + super.getFirstName() +
                ", lastName = " + super.getLastname() +
                ", team = " + team +
                ", goals = " + goals +
                "}";
    }

    public int goalsScoredTotal(Player player) {
        return player.getGoals();
    }

    public void updateStats() {
    }

    public void incrementMatchesPlayed() {
        this.matchesPlayed++;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

}

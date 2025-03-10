package com.hyperskill.data_models;

/**
 * Coach (base abstract class: Person)
 *
 * Attributes: String firstName, String lastName, String team
 * Methods: display/update stats (goals scored, matches played, average goals scored, etc.)
 */

public class Coach extends Person{
    private int id;
    private Team team;
    public Coach(int id, String firstName, String lastName, Team team){
        super(firstName, lastName);
        this.id = id;
        this.team = team;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void displayStats(){}
    public void updateStats(){}
}

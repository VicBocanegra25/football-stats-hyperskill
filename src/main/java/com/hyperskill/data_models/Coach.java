package com.hyperskill.data_models;

/**
 * Coach (base abstract class: Person)
 *
 * Attributes: String firstName, String lastName, String team
 * Methods: display/update stats (goals scored, matches played, average goals scored, etc.)
 */

public class Coach extends Person{
    private String team;
    public void displayStats(){}
    public void updateStats(){}
}

package com.hyperskill.data_models;

import java.util.List;

/**
 * Team
 *
 * Attributes: String name, List players, Coach coach
 * Methods: display/update stats (percentage of wins/losses/draws by year
 * /total, average/total goal score by year, total wins/losses/draws, etc.)
 */

public class Team {
    private int id;
    private String name;
    private List<Player> players;
    private Coach coach;

    public Team(String name){
        this.name = name;
    }

    public Team(int id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }
    public String toString(){
        return "Team {" +
                "id=" + id +
                ", name=" + name +
                "}";
    }
    public void displayStats(){}
    public void updateStats(){}
}

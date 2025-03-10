package com.hyperskill;

import com.hyperskill.data_models.Player;
import com.hyperskill.data_models.Team;

public class Main {
    public static void main(String[] args) {
        Player player = new Player(1, "Mert", "Muldur", new Team("Fenerbahce"), 101);
        FootballStatisticsDB db = new FootballStatisticsDB();
        db.addPlayer(player);
        System.out.println(db.getPlayer(1));
    }
}
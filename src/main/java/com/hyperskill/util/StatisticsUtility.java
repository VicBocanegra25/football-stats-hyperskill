package com.hyperskill.util;

import com.hyperskill.data_models.Player;
import com.hyperskill.data_models.Team;

import java.util.ArrayList;
import java.util.List;

public class StatisticsUtility {
    public static List<Team> getTopTeamsByWins(List<Team> teams, int limit) {
        List<Team> sortedTeams = new ArrayList<>(teams);
        sortedTeams.sort((t1, t2) -> t2.getWins() - t1.getWins());
        return sortedTeams.subList(0, Math.min(limit, sortedTeams.size()));
    }

    public static List<Player> getTopScorers(List<Player> players, int limit) {
        List<Player> sortedPlayers = new ArrayList<>(players);
        sortedPlayers.sort((p1, p2) -> p2.getGoals() - p1.getGoals());
        return sortedPlayers.subList(0, Math.min(limit, sortedPlayers.size()));
    }

    public static double calculateWinRatio(Team team) {
        int totalMatches = team.getWins() + team.getLosses() + team.getDraws();
        return totalMatches == 0 ? 0 : (double) team.getWins() / totalMatches;
    }

    public static double calculateGoalsPerMatch(Player player) {
        return player.getMatchesPlayed() == 0 ? 0 : 
            (double) player.getGoals() / player.getMatchesPlayed();
    }
}
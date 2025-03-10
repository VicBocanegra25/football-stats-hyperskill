package com.hyperskill.util;

import java.util.ArrayList;

public class StatisticsUtility {
    public static List<Team> getTopTeamsByWins(List<Team> teams, int limit) {
        List<Team> sortedTeams = new ArrayList<>(teams);
        sortedTeams.sort((t1, t2) -> t2.getTotalWins() - t1.getTotalWins());
        return sortedTeams.subList(0, Math.min(limit, sortedTeams.size()));
    }

    public static List<Player> getTopScorers(List<Player> players, int limit) {
        List<Player> sortedPlayers = new ArrayList<>(players);
        sortedPlayers.sort((p1, p2) -> p2.getTotalGoals() - p1.getTotalGoals());
        return sortedPlayers.subList(0, Math.min(limit, sortedPlayers.size()));
    }

    public static double calculateWinRatio(Team team) {
        int totalMatches = team.getTotalWins() + team.getTotalLosses() + team.getTotalDraws();
        return totalMatches == 0 ? 0 : (double) team.getTotalWins() / totalMatches;
    }

    public static double calculateGoalsPerMatch(Player player) {
        return player.getMatchesPlayed() == 0 ? 0 : 
            (double) player.getTotalGoals() / player.getMatchesPlayed();
    }
}
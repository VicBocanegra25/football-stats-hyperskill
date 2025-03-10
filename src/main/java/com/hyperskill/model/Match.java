package com.hyperskill.model;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Match {
    private Team team1;
    private Team team2;
    private int team1Score;
    private int team2Score;
    private Map<Player, Integer> goalScorers;
    private LocalDateTime matchDate;

    public Match(Team team1, Team team2, LocalDateTime matchDate) {
        this.team1 = team1;
        this.team2 = team2;
        this.team1Score = 0;
        this.team2Score = 0;
        this.goalScorers = new HashMap<>();
        this.matchDate = matchDate;
    }

    public void recordGoal(Player scorer) {
        goalScorers.merge(scorer, 1, Integer::sum);
        if (team1.getPlayers().contains(scorer)) {
            team1Score++;
        } else if (team2.getPlayers().contains(scorer)) {
            team2Score++;
        }
    }

    public void updateStats() {
        // Update team statistics
        updateTeamStats();
        
        // Update player statistics
        updatePlayerStats();
        
        // Update coach statistics
        updateCoachStats();
    }

    private void updateTeamStats() {
        if (team1Score > team2Score) {
            team1.recordWin();
            team2.recordLoss();
        } else if (team2Score > team1Score) {
            team2.recordWin();
            team1.recordLoss();
        } else {
            team1.recordDraw();
            team2.recordDraw();
        }
    }

    private void updatePlayerStats() {
        for (Map.Entry<Player, Integer> entry : goalScorers.entrySet()) {
            Player player = entry.getKey();
            int goals = entry.getValue();
            player.addGoals(goals);
            player.incrementMatchesPlayed();
        }
    }

    private void updateCoachStats() {
        team1.getCoach().incrementMatchesCoached();
        team2.getCoach().incrementMatchesCoached();
        
        if (team1Score > team2Score) {
            team1.getCoach().recordWin();
            team2.getCoach().recordLoss();
        } else if (team2Score > team1Score) {
            team2.getCoach().recordWin();
            team1.getCoach().recordLoss();
        } else {
            team1.getCoach().recordDraw();
            team2.getCoach().recordDraw();
        }
    }

    public String getMatchSummary() {
        StringBuilder summary = new StringBuilder();
        summary.append("Match Date: ").append(matchDate).append("\n");
        summary.append(String.format("%s %d - %d %s\n", 
            team1.getName(), team1Score, team2Score, team2.getName()));
        summary.append("Goal Scorers:\n");
        
        for (Map.Entry<Player, Integer> entry : goalScorers.entrySet()) {
            summary.append(String.format("- %s %s: %d goals\n", 
                entry.getKey().getFirstName(), 
                entry.getKey().getLastName(), 
                entry.getValue()));
        }
        
        return summary.toString();
    }

    // Getters and setters

    public Team getTeam1() {
        return team1;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    public int getTeam1Score() {
        return team1Score;
    }

    public void setTeam1Score(int team1Score) {
        this.team1Score = team1Score;
    }

    public int getTeam2Score() {
        return team2Score;
    }

    public void setTeam2Score(int team2Score) {
        this.team2Score = team2Score;
    }

    public Map<Player, Integer> getGoalScorers() {
        return goalScorers;
    }

    public void setGoalScorers(Map<Player, Integer> goalScorers) {
        this.goalScorers = goalScorers;
    }

    public LocalDateTime getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(LocalDateTime matchDate) {
        this.matchDate = matchDate;
    }
}
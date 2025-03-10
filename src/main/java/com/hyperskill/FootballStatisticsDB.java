package com.hyperskill;

import com.hyperskill.data_models.Coach;
import com.hyperskill.data_models.Player;
import com.hyperskill.data_models.Team;
import java.util.*;

public class FootballStatisticsDB {
    Map<Integer, Player> players = new HashMap<>();
    Map<Integer, Coach> coaches = new HashMap<>();
    Map<Integer, Team> teams = new HashMap<>();

    int countPlayer = 0;
    int countCoach = 0;
    int countTeam = 0;

    // Create
    public void addPlayer(Player player) {
        if(player == null){
            System.out.println("player is null.");
            return;
        }

        countPlayer++;
        players.put(countPlayer, player);
    }

    // Read
    public Player getPlayer(int id) {
        if(!players.containsKey(id)){
            return null;
        }
        return players.get(id);
    }

    public Collection<Player> getPlayers() {
        return players.values();
    }

    public Collection<Player> getPlayersByTeam(Team team) {
        Set<Player> playersTeam = new HashSet<>();
        for(Player player : players.values()){
            if(player.getTeam().equals(team)){
                playersTeam.add(player);
            }
        }
        return playersTeam;
    }

    // Update
    public void updatePlayerGoals(int id, int goals) {
        Player player = getPlayer(id);
        player.setGoals(goals);
        players.put(id,player);
    }

    public void updatePlayerTeam(int id, Team team) {
        Player player = getPlayer(id);
        player.setTeam(team);
        players.put(id,player);
    }

    // Delete
    public void deletePlayer(int id) {
        players.remove(id);
    }

    // Create
    public void addCoach(Coach coach) {
        if(coach == null){
            System.out.println("coach is null.");
            return;
        }

        countCoach++;
        coaches.put(countCoach, coach);
    }

    // Read
    public Coach getCoach(int id) {
        if(!coaches.containsKey(id)){
            return null;
        }
        return coaches.get(id);
    }

    public Collection<Coach> getCoaches() {
        return coaches.values();
    }

    public Collection<Coach> getCoachesByTeam(Team team) {
        Set<Coach> coachesTeam = new HashSet<>();
        for(Coach coach : coaches.values()){
            if(coach.getTeam().equals(team)){
                coachesTeam.add(coach);
            }
        }
        return coachesTeam;
    }

    // Update
    public void updateCoachTeam(int id, Team team) {
        Coach coach = getCoach(id);
        coach.setTeam(team);
        coaches.put(id,coach);
    }

    // Delete
    public void deleteCoach(int id) {
        coaches.remove(id);
    }

    // Create
    public void addTeam(Team team) {
        if(team == null){
            System.out.println("coach is null.");
            return;
        }

        countTeam++;
        teams.put(countTeam, team);
    }

    // Read
    public Team getTeam(int id) {
        if(!teams.containsKey(id)){
            return null;
        }
        return teams.get(id);
    }

    public Collection<Team> getTeams() {
        return teams.values();
    }

    // Update
    public void updateTeamName(int id, String name) {
        Team team = getTeam(id);
        team.setName(name);
        teams.put(id,team);
    }

    // Delete
    public void deleteTeam(int id) {
        teams.remove(id);
    }
}

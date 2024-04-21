package EncapsulationExercise.FootballTeamGenerator.FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> playerList;

    public Team(String name) {
        setName(name);
        this.playerList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name.trim().isEmpty()){
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }
    public void addPlayer(Player player){
        playerList.add(player);


    }
    public void removePlayer(String playerName){
      boolean isRemove = playerList.removeIf(p -> p.getName().equals(playerName));
      if (!isRemove){
          String message = String.format("Player %s is not in %s team.",playerName,this.name);
          throw new IllegalArgumentException(message);
      }

    }
    public double getRating(){
        return playerList.stream().mapToDouble(Player::overallSkillLevel).average().orElse(0);
    }
}

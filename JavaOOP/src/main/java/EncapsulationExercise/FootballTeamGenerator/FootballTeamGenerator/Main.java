package EncapsulationExercise.FootballTeamGenerator.FootballTeamGenerator;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String,Team> map = new LinkedHashMap<>();

        while (!input.equals("END")){
            String [] data = input.split(";");
            String command = data[0];
            String teamName = data[1];
            try {
                switch (command) {
                    case "Team":
                        Team team = new Team(teamName);
                        map.put(teamName, team);
                        break;
                    case "Add":
                        String playerName = data[2];
                        int endurance = Integer.parseInt(data[3]);
                        int sprint = Integer.parseInt(data[4]);
                        int dribble = Integer.parseInt(data[5]);
                        int passing = Integer.parseInt(data[6]);
                        int shooting = Integer.parseInt(data[7]);
                        if (!map.containsKey(teamName)) {
                            System.out.printf("Team %s does not exist.", teamName);
                        } else {
                            Player player = new Player(playerName, endurance, sprint, dribble, passing, shooting);
                            map.get(teamName).addPlayer(player);
                        }
                        break;
                    case "Remove":
                        String playerToRemove = data[2];
                        map.get(teamName).removePlayer(playerToRemove);
                        break;
                    case "Rating":
                        if (!map.containsKey(teamName)) {
                            System.out.printf("Team %s does not exist.%n", teamName);
                        } else {
                            System.out.printf("%s - %d%n", teamName, Math.round(map.get(teamName).getRating()));
                        }

                        break;


                }
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }


            input = scanner.nextLine();
        }
    }
}

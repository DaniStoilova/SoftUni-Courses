package ExamPreparation;

import java.util.*;

public class Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputLine = scanner.nextLine();

        Map<String, List<Integer>> mapCities = new LinkedHashMap<>();

        while (!inputLine.equals("Sail")) {
            String[] input = inputLine.split("\\|\\|");
            String city = input[0];
            int population = Integer.parseInt(input[1]);
            int gold = Integer.parseInt(input[2]);

            if (mapCities.containsKey(city)) {

                int newPopulation = mapCities.get(city).get(0) + population;
                int newGold = mapCities.get(city).get(1) + gold;

                mapCities.get(city).add(0, newPopulation);
                mapCities.get(city).add(1, newGold);


            } else {
                mapCities.putIfAbsent(city, new ArrayList<>());

                mapCities.get(city).add(0, population);
                mapCities.get(city).add(1, gold);
            }
            inputLine = scanner.nextLine();
        }
        String command = scanner.nextLine();

        while (!command.equals("End")) {
            String[] commandLine = command.split("=>");
            String line = commandLine[0];

            String town = commandLine[1];
            int population = mapCities.get(town).get(0);
            int gold = mapCities.get(town).get(1);

            switch (line) {
                case "Plunder":
                    int peoplePlunder = Integer.parseInt(commandLine[2]);
                    int goldPlunder = Integer.parseInt(commandLine[3]);

                    if (mapCities.containsKey(town)) {
                        mapCities.get(town).set(0, population - peoplePlunder);
                        mapCities.get(town).set(1, gold - goldPlunder);


                        System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", town, goldPlunder, peoplePlunder);
                    } else {

                    }
                    if (population - peoplePlunder == 0 | gold - goldPlunder == 0) {
                        mapCities.remove(town);
                        System.out.printf("%s has been wiped off the map!%n", town);
                    }


                    break;
                case "Prosper":
                    int goldProsper = Integer.parseInt(commandLine[2]);
                    if (goldProsper < 0) {
                        System.out.println("Gold added cannot be a negative number!");
                    } else {
                        mapCities.get(town).set(1, gold + goldProsper);
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", goldProsper, town, gold + goldProsper);
                    }


                    break;


            }


            command = scanner.nextLine();
        }


        System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", mapCities.size());
        for (Map.Entry<String, List<Integer>> entry : mapCities.entrySet()) {
            System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n", entry.getKey(),
                    entry.getValue().get(0), entry.getValue().get(1));
        }


    }

}


package ExamPreparation;

import java.nio.file.LinkPermission;
import java.util.*;

public class Plant {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> mapPlant = new LinkedHashMap<>();

        Map<String, Double> mapRating = new LinkedHashMap<>();

        for (int i = 1; i <= n; i++) {
            String data = scanner.nextLine();
            String plant = data.split("<->")[0];
            int rarity = Integer.parseInt(data.split("<->")[1]);

            mapPlant.put(plant, rarity);

        }

        String command = scanner.nextLine();
        int count = 1;
        while (!command.equals("Exhibition")) {
            String[] commandLine = command.split(": ");
            String line = commandLine[0];
            String element = commandLine[1];
            String plant = element.split(" - ")[0];

            if(!mapPlant.containsKey(plant)){

                System.out.println("error");
                command = scanner.nextLine();
                continue;
            }


            if (line.contains("Rate")) {
                double rating = Double.parseDouble(element.split(" - ")[1]);

                if (!mapRating.containsKey(plant)) {


                    mapRating.put(plant, rating);


                } else {
                    double current = mapRating.get(plant);
                    count++;
                    mapRating.put(plant, (current + rating) / count);
                }


            } else if (line.contains("Update")) {
                int newRating = Integer.parseInt(element.split(" - ")[1]);

                if (mapPlant.containsKey(plant)) {

                    mapPlant.put(plant, newRating);
                }

            } else if (line.contains("Reset")) {

                if (mapRating.containsKey(plant)) {


                }
                mapRating.put(plant, 0.0);

            }else{
                System.out.printf("error");
            }

            command = scanner.nextLine();
        }

        System.out.println("Plants for the exhibition:");
        double total = 0;
        for (Map.Entry<String, Integer> entry : mapPlant.entrySet()) {
            String plant = entry.getKey();
            int rarity = entry.getValue();


            System.out.printf("- %s; Rarity: %d; Rating: %.2f%n",
                    plant, rarity, mapRating.get(plant));
        }
    }

}

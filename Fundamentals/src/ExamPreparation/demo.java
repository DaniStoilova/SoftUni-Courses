package ExamPreparation;

import java.util.*;

public class demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> rarity = new HashMap<>();
        Map<String, List<Double>> rating = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            String[] tokens = scanner.nextLine().split("<->");
            String plant = tokens[0];
            int rarityPlant = Integer.parseInt(tokens[1]);
            rarity.put(plant, rarityPlant);
            rating.putIfAbsent(plant, new ArrayList<>());
        }
        String input = scanner.nextLine();
        while (!input.equals("Exhibition")) {
            String[] command = input.split(": ");
            String[] newToken = command[1].split(" - ");
            String name = newToken[0];

            if (!rarity.containsKey(name)) {
                System.out.println("error");
                input = scanner.nextLine();
                continue;
            }

            switch (command[0]) {
                case "Rate":
                    double rating2 = Double.parseDouble(newToken[1]);
                    rating.get(name).add(rating2);
                    break;

                case "Update":
                    int newRarity = Integer.parseInt(newToken[1]);
                    rarity.put(name, newRarity);
                    break;
                case "Reset":
                    rating.get(name).clear();
                    break;
                default:
                    System.out.println("error");
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println("Plants for the exhibition:");

        rarity.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue()
                        .thenComparingDouble(x -> rating.get(x.getKey()).stream()
                                .mapToDouble(Double::doubleValue)
                                .average().orElse(0.0))
                        .reversed())
                .forEach(entry -> System.out.printf("- %s; Rarity: %d; Rating: %.2f%n",
                        entry.getKey(), entry.getValue(),
                        rating.get(entry.getKey()).stream()
                                .mapToDouble(Double::doubleValue)
                                .average().orElse(0.0)));
    }
}
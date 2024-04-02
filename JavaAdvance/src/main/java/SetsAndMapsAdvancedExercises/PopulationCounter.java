package SetsAndMapsAdvancedExercises;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        LinkedHashMap<String, LinkedHashMap<String, Long>> map = new LinkedHashMap<>();
        LinkedHashMap<String, Long> map1 = new LinkedHashMap<>();

        while (!input.equals("report")) {
            String[] line = input.split("\\|");

            String city = line[0];
            String country = line[1];
            Long population = Long.parseLong(line[2]);

            if (!map.containsKey(country)) {
                map.put(country, new LinkedHashMap<>());
                map1.put(country, population);
            }else {
                long value = map1.get(country);
                map1.put(country, value + population);
            }
            if (!map.get(country).containsKey(city)) {
                map.get(country).put(city, population);
            }
            input = scanner.nextLine();
        }
        map.entrySet().stream()
                .sorted((a, b) -> map1.get(b.getKey()).compareTo(map1.get(a.getKey())))
                .forEach(country -> {
                    System.out.format("%s (total population: %d)%n", country.getKey(), map1.get(country.getKey()));
                    country.getValue().entrySet()
                            .stream().sorted((a, b) -> b.getValue().compareTo(a.getValue())).forEach(city -> {
                                System.out.format("=>%s: %d%n", city.getKey(), city.getValue());
                            });
                });
    }

}

package SetsAndMapsAdvancedLab;

import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, LinkedHashMap<String, List<String>>> map = new LinkedHashMap<>();
        while (n-- > 0){
            String [] input = scanner.nextLine().split(" ");
            String continent = input[0];
            String country = input[1];
            String city = input[2];

            if (!map.containsKey(continent)){
                map.put(continent,new LinkedHashMap<>());
            }
            Map<String,List<String>> countries = map.get(continent);
            countries.putIfAbsent(country,new ArrayList<>());
            List<String> cities = countries.get(country);
            cities.add(city);
        }

        for (Map.Entry<String, LinkedHashMap<String, List<String>>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":");
            entry.getValue().entrySet().stream().forEach(e->{
                String cities = String.join(", ",e.getValue());
                System.out.println("  " + e.getKey() + " -> " + cities);

            });

        }
    }
}

package SetsAndMapsAdvancedExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class СръбскоUnleashed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String  regex = "(?<name>([a-zA-Z]+\\s){1,3})@(?<town>([a-zA-Z]+\\s){1,3})(?<price>\\d+)\\s(?<count>\\d+)";
        Pattern pattern = Pattern.compile(regex);

        LinkedHashMap<String, LinkedHashMap<String, Integer>> map = new LinkedHashMap<>();

        while (!input.equals("End")){

            Matcher matcher = pattern.matcher(input);

            if (matcher.find()){

                String name = matcher.group("name");
                String town = matcher.group("town");
                int price = Integer.parseInt(matcher.group( "price"));
                int count = Integer.parseInt(matcher.group( "count"));

                int total = price * count;

                if (!map.containsKey(town)){
                    map.put(town,new LinkedHashMap<>());
                }
                if (!map.get(town).containsKey(name)){
                    map.get(town).put(name,total);
                }else{
                    int value = map.get(town).get(name);
                    map.get(town).put(name,value + total);
                }
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : map.entrySet()) {
            String town = entry.getKey();
            LinkedHashMap<String, Integer> map1 = entry.getValue();
            System.out.println(town);

            map1.entrySet().stream().sorted((a,b)->b.getValue().compareTo(a.getValue()))
                    .forEach(e->
                            System.out.printf("#  %s-> %d%n",e.getKey(),e.getValue()));
        }
    }
}

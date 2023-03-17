package MoreExersice;

import java.sql.Array;
import java.util.*;

public class Judge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, String> map = new LinkedHashMap<>();

        Map<String, Integer> map1 = new LinkedHashMap<>();


        while (!input.equals("no more time")) {

            String[] line = input.split(" -> ");
            String userName = line[0];
            String contest = line[1];
            int points = Integer.parseInt(line[2]);


            map.put(userName, contest);


            if (!map1.containsKey(contest)) {

                map1.put(userName, points);
            } else {

            }

            input = scanner.nextLine();


        }
        for (Map.Entry<String, String> e : map.entrySet()) {
            String name = e.getKey();
            String value = e.getValue();

            System.out.printf("%s: %d participants%n", value,value.length());
            System.out.printf("%s <::> %d%n", name, map1.get(name));


        }
    }
}
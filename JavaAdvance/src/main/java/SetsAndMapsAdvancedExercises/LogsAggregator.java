package SetsAndMapsAdvancedExercises;

import java.util.*;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        TreeMap<String, TreeMap<String, Integer>> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String ip = input[0];
            String users = input[1];
            int duration = Integer.parseInt(input[2]);


            if (!map.containsKey(users)) {
                map.put(users, new TreeMap<>());
            }
            if (!map.get(users).containsKey(ip)) {
                map.get(users).put(ip, duration);
            } else {
                int dur = map.get(users).get(ip);
                map.get(users).put(ip, duration + dur);
            }

        }
        for (Map.Entry<String, TreeMap<String, Integer>> entry : map.entrySet()) {
            String users = entry.getKey();
            TreeMap<String, Integer> map1 = entry.getValue();
            int total = 0;
            for (int num : map1.values()) {
                total += num;
            }
            List<String> ip = new ArrayList<>();
            for (String s : map1.keySet()) {
                ip.add(s);
            }

            System.out.println(users + ": " + total + " " + ip);


        }


    }
}

package SetsAndMapsAdvancedExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
//              user                    IP  CountIP
        TreeMap<String,LinkedHashMap<String, Integer>> users = new TreeMap<>();

        while (!input.equals("end")){

            String[] parts = input.split(" ");
            String nameUsers = parts[2].substring(5);
            String ipAddress = parts[0].substring(3);

            if (!users.containsKey(nameUsers)){
                users.put(nameUsers,new LinkedHashMap<>());
            }
            if (!users.get(nameUsers).containsKey(ipAddress)){
                users.get(nameUsers).put(ipAddress,1);
            }else{
                int count = users.get(nameUsers).get(ipAddress) + 1;
                users.get(nameUsers).put(ipAddress,count);
            }


            input = scanner.nextLine();

        }


        users.entrySet().stream()
                .forEach(e -> {
                    System.out.println(e.getKey() + ":");

                    int count = 0;
                    Map<String, Integer> value = e.getValue();

                    for (Map.Entry<String, Integer> secondMap : value.entrySet()) {

                        String format =
                                (count++ == value.size() - 1)
                                        ? "%s => %d.%n"
                                        : "%s => %d, ";

                        System.out.printf(format, secondMap.getKey(), secondMap.getValue());
                    }


                });

    }
}

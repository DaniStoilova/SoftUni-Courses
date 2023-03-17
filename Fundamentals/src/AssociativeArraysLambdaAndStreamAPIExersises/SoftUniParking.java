package AssociativeArraysLambdaAndStreamAPIExersises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        Map<String, String> map = new LinkedHashMap<>();

        for (int i = 1; i <= n; i++) {
            String[] commandLine = scanner.nextLine().split(" ");
            String command = commandLine[0];
            String username = commandLine[1];


            switch (command) {
                case "register":
                    String licencePlateNumber = commandLine[2];
                    if (map.containsKey(username)) {

                        System.out.printf("ERROR: already registered with plate number %s%n", map.get(username));
                    } else {
                        map.put(username, licencePlateNumber);
                        System.out.printf("%s registered %s successfully%n", username, licencePlateNumber);
                    }
                    break;
                case "unregister":

                    if (!map.containsKey(username)) {
                        System.out.printf("ERROR: user %s not found%n", username);
                    } else {
                        map.remove(username);
                        System.out.printf("%s unregistered successfully%n", username);
                    }

                    break;
            }


        }
        for (Map.Entry<String, String> entry : map.entrySet()) {

            System.out.printf("%s => %s%n", entry.getKey(), entry.getValue());
        }


    }
}

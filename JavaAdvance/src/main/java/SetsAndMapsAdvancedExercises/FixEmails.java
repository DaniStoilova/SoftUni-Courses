package SetsAndMapsAdvancedExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        LinkedHashMap<String, String> map = new LinkedHashMap<>();

        while (!input.equals("stop")) {

            String email = scanner.nextLine();
            if (!email.endsWith("us") && !email.endsWith("uk") && !email.endsWith("com")) {
                map.put(input, email);
            }


            input = scanner.nextLine();


        }
        for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
            System.out.printf("%s -> %s%n", stringStringEntry.getKey(), stringStringEntry.getValue());
        }


    }
}

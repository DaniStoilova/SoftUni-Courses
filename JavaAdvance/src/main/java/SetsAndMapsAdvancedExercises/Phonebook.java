package SetsAndMapsAdvancedExercises;

import java.util.HashMap;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        HashMap<String, String> map = new HashMap<>();

        while (!input.equals("search")) {
            String[] info = input.split("-");
            String name = info[0];
            String number = info[1];

            map.put(name, number);


            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        while (!input.equals("stop")) {

            if (map.containsKey(input)) {
                System.out.printf("%s -> %s%n", input, map.get(input));
            } else {
                System.out.printf("Contact %s does not exist.%n", input);


            }

            input = scanner.nextLine();
        }
    }
}

package SetsAndMapsAdvancedExercises;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        int first = Integer.parseInt(input[0]);
        int second = Integer.parseInt(input[1]);

        LinkedHashSet<String> firstSet = new LinkedHashSet<>();

        for (int i = 0; i < first; i++) {
            String element = scanner.nextLine();
            firstSet.add(element);
        }
        LinkedHashSet<String> secondSet = new LinkedHashSet<>();

        for (int i = 0; i < second; i++) {
            String element = scanner.nextLine();
            secondSet.add(element);
        }

        for (String element : firstSet) {
            if (secondSet.contains(element)) {

                System.out.print(element + " ");

            }
        }


    }
}

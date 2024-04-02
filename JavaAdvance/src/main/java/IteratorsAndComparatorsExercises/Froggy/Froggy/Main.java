package IteratorsAndComparatorsExercises.Froggy.Froggy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Integer[] data = Arrays.stream(input.split(", "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        Lake lake = new Lake(data);

        List<String> result = new ArrayList<>();

        while (!input.equals("END")) {

            for (Integer integer : lake) {
                result.add(String.valueOf(integer));
            }




            input = scanner.nextLine();
        }

        System.out.println(String.join(", ",result));
    }
}

package IteratorsAndComparatorsExercises.StackIterator.StackIterator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Stack<Integer> stack = new Stack<>();

        while (!input.equals("END")) {
            String[] data = input.split("[, ]+");
            String command = data[0];

            switch (command) {
                case "Push":
                    for (int i = 1; i < data.length; i++) {
                        stack.push(Integer.parseInt(data[i]));
                    }
                    break;
                case "Pop":
                    try {
                        stack.pop();
                    } catch (Exception e) {
                        System.out.println("No elements");
                    }
                    break;

            }


            input = scanner.nextLine();
        }
        for (int i = 1; i <= 2; i++) {
            for (Integer integer : stack) {
                System.out.println(integer);
            }
        }


    }
}

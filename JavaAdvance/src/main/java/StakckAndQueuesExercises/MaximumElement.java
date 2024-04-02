package StakckAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] commandLine = scanner.nextLine().split(" ");
            String command = commandLine[0];
            switch (command) {
                case "1":
                    int numToAdd = Integer.parseInt(commandLine[1]);
                    stack.push(numToAdd);
                    break;
                case "2":
                    stack.pop();
                    break;
                case "3":
                    int max = Collections.max(stack);
                    System.out.println(max);
                    break;
            }

        }

    }
}

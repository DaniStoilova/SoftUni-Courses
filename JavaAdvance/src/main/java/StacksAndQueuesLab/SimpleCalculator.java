package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] number = scanner.nextLine().split(" ");

        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = number.length - 1; i >= 0; i--) {
            String currentElement = number[i];
            stack.push(currentElement);


        }
        while (stack.size() > 1) {
            int first = Integer.valueOf(stack.pop());
            String operator = stack.pop();
            int second = Integer.valueOf(stack.pop());

            if (operator.equals("+")) {
                stack.push(String.valueOf(first + second));
            } else if (operator.equals("-")) {
                stack.push(String.valueOf(first - second));
            }


        }

        System.out.println(stack.pop());
    }
}

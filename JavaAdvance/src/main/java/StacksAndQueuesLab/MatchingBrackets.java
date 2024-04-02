package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String expression = scanner.nextLine();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < expression.length(); i++) {
            char brackets = expression.charAt(i);

            if (brackets == '(') {
                stack.push(i);
            } else if (brackets == ')') {
                int start = stack.pop();
                int end = i;

                String text = expression.substring(start, end + 1);

                System.out.println(text);

            }

        }


    }
}

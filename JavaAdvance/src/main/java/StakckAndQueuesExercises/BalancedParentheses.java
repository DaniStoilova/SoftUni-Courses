package StakckAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String brackets = scanner.nextLine();

        ArrayDeque<Character> stack = new ArrayDeque<>();
        boolean isBalance = true;
        for (int i = 0; i < brackets.length(); i++) {
            char currentBrackets = brackets.charAt(i);

            if (currentBrackets == '(' || currentBrackets == '[' || currentBrackets == '{') {
                stack.push(currentBrackets);
            } else {
                if (stack.isEmpty()) {
                    isBalance = false;
                    break;
                }
                char lastBrackets = stack.pop();

                if (currentBrackets == '}' && lastBrackets != '{') {
                    isBalance = false;
                    break;
                } else if (currentBrackets == ')' && lastBrackets != '(') {
                    isBalance = false;
                    break;
                } else if (currentBrackets == ']' && lastBrackets != '[') {
                    isBalance = false;
                    break;
                }
            }


        }
        if (isBalance && stack.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}

package StakckAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class ReverseNumbersWithAStack {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            String[] elements = scanner.nextLine().split(" ");

            Deque<String> stack = new ArrayDeque<>();

            for (String element : elements) {
                stack.push(element);
            }

            while (!stack.isEmpty()) {
                System.out.printf("%s ", stack.pop());
            }


        }

}

package StakckAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] elements = scanner.nextLine().split(" ");
        String[] numbers = scanner.nextLine().split(" ");

        int elementsToPush = Integer.parseInt(elements[0]);
        int elementsToPop = Integer.parseInt(elements[1]);
        int elementsToSearch = Integer.parseInt(elements[2]);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < elementsToPush; i++) {
            stack.push(Integer.parseInt(numbers[i]));
        }

        for (int i = 0; i < elementsToPop; i++) {
            stack.pop();
        }

        if (stack.isEmpty()) {
            System.out.println("0");
        } else if (stack.contains(elementsToSearch)) {
            System.out.println("true");
        } else {
//            int min = Integer.MAX_VALUE;
//            for (Integer integer : stack) {
//                if (integer < min) {
//                    min = integer;
//                }
//            }
//            System.out.println(min);
//            int minElement = Collections.min(stack);
//            System.out.println(minElement);
            int minElement =stack.stream().mapToInt(e->e).min().getAsInt();
            System.out.println(minElement);

        }

    }
}



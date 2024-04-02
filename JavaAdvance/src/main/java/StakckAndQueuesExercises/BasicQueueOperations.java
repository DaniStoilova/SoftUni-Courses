package StakckAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] elements = scanner.nextLine().split(" ");
        String[] numbers = scanner.nextLine().split(" ");

        int elementsToOffer = Integer.parseInt(elements[0]);
        int elementsToPoll = Integer.parseInt(elements[1]);
        int elementsToSearch = Integer.parseInt(elements[2]);

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < elementsToOffer; i++) {
            queue.offer(Integer.parseInt(numbers[i]));
        }

        for (int i = 0; i < elementsToPoll; i++) {
            queue.poll();
        }

        if (queue.isEmpty()) {
            System.out.println("0");
        } else if (queue.contains(elementsToSearch)) {
            System.out.println("true");
        } else {

            int minElement = Collections.min(queue);
            System.out.println(minElement);


        }

    }

}

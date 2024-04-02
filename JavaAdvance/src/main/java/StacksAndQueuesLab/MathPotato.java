package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] name = scanner.nextLine().split(" ");

        int n = Integer.parseInt(scanner.nextLine());


        ArrayDeque<String> queue = new ArrayDeque<>();

        for (String child : name) {
            queue.offer(child);
        }

        int cycle = 1;

        while (queue.size() > 1) {
            for (int i = 1; i < n; i++) {
                queue.offer(queue.poll());


            }
            if (cycle > 1 && cycle % 2 == 1 || cycle == 2) {

                System.out.println("Prime " + queue.peek());

            } else {
                System.out.println("Removed " + queue.poll());


            }

            cycle++;
        }

        System.out.println("Last is " + queue.poll());


    }

}

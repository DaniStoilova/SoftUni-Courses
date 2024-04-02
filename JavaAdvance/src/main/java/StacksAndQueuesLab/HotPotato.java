package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] childName = scanner.nextLine().split(" ");

        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> queue = new ArrayDeque<>();

        for (String name : childName) {
            queue.offer(name);
        }
        while (queue.size() > 1){
            for (int i = 1; i < n; i++) {
                queue.offer(queue.poll());

            }

            System.out.println("Removed " + queue.poll() );
        }
        System.out.println("Last is " + queue.poll() );
    }
}

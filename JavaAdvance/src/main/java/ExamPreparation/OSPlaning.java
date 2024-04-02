package ExamPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OSPlaning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //stack
        ArrayDeque<Integer> tasks = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(tasks::push);

        ArrayDeque<Integer> threads = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        int endTask = Integer.parseInt(scanner.nextLine());

        int task = tasks.peek();
        int thread = threads.peek();

        while (task != endTask) {

            if (thread >= task) {
                tasks.pop();
                threads.poll();
            } else {
                threads.poll();
            }


            task = tasks.peek();
            thread = threads.peek();
        }
        System.out.println("Thread with value " + threads.peek() + " killed task " + endTask);
        String result = threads.stream().map(String::valueOf)
                .collect(Collectors.joining(" "));

        System.out.print(result);


    }
}

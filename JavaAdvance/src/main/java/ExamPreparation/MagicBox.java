package ExamPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MagicBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstBox = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> secondBox = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .forEach(secondBox::push);

        int resultItem = 0;

        while (!firstBox.isEmpty() && !secondBox.isEmpty()) {
            int first = firstBox.peek();
            int second = secondBox.peek();

            int sum = first + second;

            if (sum % 2 == 0) {
                resultItem += sum;
                firstBox.poll();
                secondBox.pop();

            } else {
                secondBox.pop();
                firstBox.addLast(second);
            }


        }
        if (firstBox.isEmpty()) {
            System.out.println("First magic box is empty.");
        } else {
            System.out.println("Second magic box is empty.");
        }
        if (resultItem >= 90) {
            System.out.printf("Wow, your prey was epic! Value: %d", resultItem);
        } else {
            System.out.printf("Poor prey... Value: %d", resultItem);
        }


    }
}

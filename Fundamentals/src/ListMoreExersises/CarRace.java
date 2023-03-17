package ListMoreExersises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CarRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> carLeft = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int length = carLeft.size() / 2;
        double sum = 0;
        for (int i = 0; i < length; i++) {
            int left = carLeft.get(i);
            sum += left;
            if (left == 0) {
                sum = sum * 0.8;
            }

        }
        double sumRight = 0;
        for (int i = carLeft.size() - 1; i > length; i--) {
            int right = carLeft.get(i);
            sumRight += right;
            if (right == 0) {
                sumRight = sumRight * 0.8;
            }
        }
        if (sum < sumRight) {
            System.out.printf("The winner is left with total time: %.1f%n", sum);
        } else {
            System.out.printf("The winner is right with total time: %.1f%n", sumRight);


        }
    }
}

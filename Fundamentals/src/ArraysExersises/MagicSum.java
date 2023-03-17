package ArraysExersises;

import java.util.Arrays;
import java.util.Scanner;

public class MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sum = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i <= numbers.length - 1; i++) {
            int currentNumber = numbers[i];
            int sumCurrent = 0;
            for (int j = i + 1; j <= numbers.length - 1; j++) {


                sumCurrent = numbers[i] + numbers[j];

                if (sum == sumCurrent) {
                    System.out.println(numbers[i] + " " + numbers[j]);
                }
            }
        }

    }
}

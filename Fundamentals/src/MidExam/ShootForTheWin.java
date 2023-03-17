package MidExam;

import java.util.Arrays;
import java.util.Scanner;

public class ShootForTheWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String input = scanner.nextLine();
        int shoot = 0;
        while (!input.equals("End")) {
            int index = Integer.parseInt(input);
            if (index >= 0 && index <= numbers.length - 1) {
                shoot++;
                int num = numbers[index];
                for (int i = 0; i <= numbers.length - 1; i++) {
                    numbers[index] = -1;
                    if (num < numbers[i] && numbers[i] != -1) {
                        numbers[i] -= num;
                    } else if (num >= numbers[i] && numbers[i] != -1) {
                        numbers[i] += num;
                    }
                }
            }
            input = scanner.nextLine();
        }
        System.out.printf("Shot targets: %d -> ",shoot);
        for (int num:numbers) {
            System.out.print(num + " ");
        }
    }
}

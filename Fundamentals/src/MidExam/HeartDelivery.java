package MidExam;

import java.util.Arrays;
import java.util.Scanner;

public class HeartDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numberArr = scanner.nextLine().split("\\@");

        int[] numbers = Arrays
                .stream(numberArr)
                .mapToInt(Integer::parseInt)
                .toArray();

        String input = scanner.nextLine();

        int currentIndex = 0;
        while (!input.equals("Love!")) {
            String[] command = input.split(" ");
            String line = command[0];
            if (line.equals("Jump")) {
                int length = Integer.parseInt(command[1]);
                currentIndex += length;
                if (currentIndex >= numbers.length) {
                    currentIndex = 0;
                }
                if (numbers[currentIndex] != 0) {
                    numbers[currentIndex] -= 2;
                    if (numbers[currentIndex] == 0) {
                        System.out.printf("Place %d has Valentine's day.%n", currentIndex);
                    }
                } else {
                    System.out.printf("Place %d already had Valentine's day.%n", currentIndex);
                }
                input = scanner.nextLine();

            }

        }
        System.out.printf("Cupid's last position was %d.%n", currentIndex);
        int count = 0;
        for (int house : numbers) {
            if (house != 0) {
                count++;
            }
        }
        if (input.equals("Love")) {
            System.out.println("Mission was successful.");
        } else {
            System.out.printf("Cupid has failed %d places.%n", count);
        }

    }
}



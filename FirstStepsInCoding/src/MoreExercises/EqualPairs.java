package MoreExercises;

import java.util.Scanner;

public class EqualPairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int max = Integer.MIN_VALUE;
        int sum = 0;
        int diff = 0;
        for (int i = 1; i <= 2 * n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            sum += number;

        }

        if (max < sum) {
            max = sum;
                System.out.printf("Yes, value=%d", sum);
            } else {

            System.out.printf("No, maxdiff=%d", (max));
            }

        }

    }

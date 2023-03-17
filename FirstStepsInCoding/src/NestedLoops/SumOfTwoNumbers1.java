package NestedLoops;

import java.util.Scanner;

public class SumOfTwoNumbers1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int combination = 0;
        int start = Integer.parseInt(scanner.nextLine());
        int end = Integer.parseInt(scanner.nextLine());
        int magicNumber = Integer.parseInt(scanner.nextLine());

        boolean isFound = false;
        for (int i = start; i <= end; i++) {
            for (int j = start; j <= end; j++) {
                combination++;
                if (i + j == magicNumber) {
                    System.out.printf("Combination N:%d (%d + %d = %d)%n", combination, i, j, magicNumber);
                    isFound = true;
                    break;
                }
            }
            if (isFound) {
                break;
            }
        }
        if (!isFound) {
            System.out.printf("%d combinations - neither equals %d", combination, magicNumber);
        }
    }
}


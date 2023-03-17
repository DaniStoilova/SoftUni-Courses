package NestedLoops;

import java.util.Scanner;

public class EqualSumsEvenOddPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int first = Integer.parseInt(scanner.nextLine());
        int second = Integer.parseInt(scanner.nextLine());

        for (int i = first; i <= second; i++) {

            int currentNumber = i;
            int evenSum = 0;
            int oddSum = 0;

            for (int j = 6; j > 0; j--) {
                int d = currentNumber % 10;
                if (j % 2 == 0) {
                    evenSum += d;
                } else {
                    oddSum += d;
                }
                currentNumber = currentNumber / 10;
            }
            if (evenSum == oddSum) {
                System.out.print(i + " ");
            }
        }
    }
}

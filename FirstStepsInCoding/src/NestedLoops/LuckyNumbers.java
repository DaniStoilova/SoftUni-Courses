package NestedLoops;

import java.util.Scanner;

public class LuckyNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int number = Integer.parseInt(scanner.nextLine());

        boolean isFinish = false;

        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                for (int k = 1; k <= 9; k++) {
                    for (int l = 1; l <= 9; l++) {
                        boolean magicNumber = (i + j == k + l && number % (i + j) == 0);
                        if (magicNumber) {

                            System.out.printf("%d%d%d%d ", i, j, k, l);

                        }

                    }

                }

            }
        }
    }
}







package NestedLoops;

import java.util.Scanner;

public class BarcodeGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int start = Integer.parseInt(scanner.nextLine());
        int end = Integer.parseInt(scanner.nextLine());

        int a1 = (start / 1000) % 10;
        int a2 = (start / 100) % 10;
        int a3 = (start / 10) % 10;
        int a4 = (start % 10);

        int b1 = (end / 1000) % 10;
        int b2 = (end / 100) % 10;
        int b3 = (end / 10) % 10;
        int b4 = (end % 10);


        for (int i = a1; i <= b1; i++) {
            for (int j = a2; j <= b2; j++) {
                for (int l = a3; l <= b3; l++) {
                    for (int k = a4; k <= b4; k++) {

                        boolean isOdd = (i % 2 != 0 && j % 2 != 0 && l % 2 != 0 && k % 2 != 0);
                        if (isOdd) {
                            System.out.printf("%d%d%d%d ", i, j, l, k);
                        }
                    }


                }

            }
        }
    }
}

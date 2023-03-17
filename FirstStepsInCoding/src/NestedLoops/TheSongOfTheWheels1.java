package NestedLoops;

import java.util.Scanner;

public class TheSongOfTheWheels1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int m = Integer.parseInt(scanner.nextLine());


        int counter = 0;
        boolean isFinish = false;
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                for (int k = 1; k <= 9; k++) {
                    for (int l = 1; l <= 9; l++) {
                        if (i * j + k * l == m && i < j && k > l) {
                            counter++;
                            System.out.printf("%d%d%d%d ", i, j, k, l);
                            System.out.println();
                            if (counter == 4) {
                                System.out.printf("Password: %d%d%d%d%n", i, j, k, l);


                            }
                        }

                    }
                }


            }
        }
    }
}




















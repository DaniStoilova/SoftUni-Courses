package exam;

import java.util.Scanner;

public class UniquePINCodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int endFirst = Integer.parseInt(scanner.nextLine());
        int endSecond = Integer.parseInt(scanner.nextLine());
        int endThird = Integer.parseInt(scanner.nextLine());




        for (int i = 1; i <= endFirst; i++) {
            for (int j = 2; j <= endSecond ; j++) {
                for (int k = 1; k <= endThird; k++) {
                    if (i % 2 == 0) {
                            if (j == 2  || j == 3 || j == 5 || j == 7) {
                                if (k % 2 == 0) {
                                    System.out.printf("%d %d %d%n", i, j, k);
                                }
                            }
                        }
                    }
                }
            }
        }
    }





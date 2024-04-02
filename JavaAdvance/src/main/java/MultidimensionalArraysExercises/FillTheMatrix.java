package MultidimensionalArraysExercises;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] input = scanner.nextLine().split(", ");
        int n = Integer.parseInt(input[0]);
        String pattern = input[1];

        int counter = 1;
        int[][] matrix = new int[n][n];

        if (pattern.equals("A")) {
            patternA(n, counter, matrix);
        }else if (pattern.equals("B")) {
            patternB(n, counter, matrix);
        }
        printMatrix(n, matrix);


    }

    private static void patternB(int n, int counter, int[][] matrix) {
        for (int col = 0; col < n; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < n; row++) {
                    matrix[row][col] = counter;
                    counter++;

                }
            }else{
                for (int row = n -1; row >= 0 ; row--) {
                    matrix[row][col] = counter;
                    counter++;
                }
            }
        }
    }

    private static int patternA(int n, int counter, int[][] matrix) {
        for (int col = 0; col < n; col++) {
            for (int row = 0; row < n; row++) {
                matrix[row][col] = counter;
                counter++;
            }
        }
        return counter;
    }

    private static void printMatrix(int n, int[][] matrix) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}

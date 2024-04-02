package MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][n];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays
                    .stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

        }

//        for (int i = 0; i < matrix.length; i++) {
//            System.out.print(matrix[i][i] + " ");
//        }
//
//        System.out.println();
//
//        for (int i = matrix.length - 1; i >= 0; i--) {
//
//            System.out.print(matrix[i-1][i+1] + " ");
//        }

        int rows = 0;
        int cols = 0;

        while (rows < matrix.length && cols < matrix[rows].length) {
            System.out.print(matrix[rows][cols] + " ");
            rows++;
            cols++;

        }
        System.out.println();

        rows = matrix.length - 1;
        cols = 0;
        while (rows >= 0 && cols < matrix[rows].length) {
            System.out.print(matrix[rows][cols] + " ");
            rows--;
            cols++;
        }
    }
}

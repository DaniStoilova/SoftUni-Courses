package MultidimensionalArraysLab;

import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimentions = scanner.nextLine().split(", ");

        int rows =Integer.parseInt(dimentions[0]);
        int cols = Integer.parseInt(dimentions[1]);

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] elements = scanner.nextLine().split(", ");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Integer.parseInt(elements[col]);
            }
        }

        int sum = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                sum += matrix[row][col];


            }
        }
        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);


    }
}

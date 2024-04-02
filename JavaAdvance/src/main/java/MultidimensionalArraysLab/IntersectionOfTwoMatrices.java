package MultidimensionalArraysLab;

import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());


        char[][] firstMatrix = new char[rows][cols];
        char[][] secondMatrix = new char[rows][cols];

        readMatrix(scanner, rows, cols, firstMatrix);
        readMatrix(scanner, rows, cols, secondMatrix);


        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                char c = firstMatrix[row][col];
                if (c == secondMatrix[row][col]) {
                    System.out.print(c + " ");
                } else {
                    c = '*';
                    System.out.print(c + " ");
                }

            }
            System.out.println();

        }

    }




    private static void readMatrix(Scanner scanner, int rows, int cols, char[][] matrix) {
        for (int row = 0; row < rows; row++) {
            String[] arr = scanner.nextLine().split(" ");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = arr[col].charAt(0);
            }


        }
    }
}

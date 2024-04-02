package MultidimensionalArraysExercises;

import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        int row = Integer.parseInt(input[0]);
        int col = Integer.parseInt(input[1]);


        String[][] matrix = new String[row][col];

        for (int rows = 0; rows < row; rows++) {
            for (int cols = 0; cols < col; cols++) {
                char outside = (char) ('a' + rows);
                char middle = (char) ('a' + rows + cols);
                matrix[rows][cols] = String.valueOf(outside) + middle + outside;
            }
        }

        for (int rows = 0; rows < row; rows++) {
            for (int cols = 0; cols < col; cols++) {
                System.out.print(matrix[rows][cols] + " ");
            }
            System.out.println();
        }


    }
}

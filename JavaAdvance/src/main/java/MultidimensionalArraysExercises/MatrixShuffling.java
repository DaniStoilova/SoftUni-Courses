package MultidimensionalArraysExercises;

import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] dimentions = scanner.nextLine().split(" ");

        int rows = Integer.parseInt(dimentions[0]);
        int cols = Integer.parseInt(dimentions[1]);


        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] numbers = scanner.nextLine().split(" ");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = numbers[col];
            }
        }


        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String[] command = input.split(" ");
            if (!input.contains("swap")) {

                System.out.println("Invalid input!");
                input = scanner.nextLine();
                continue;
            }

            String line = command[0];
            int row1 = Integer.parseInt(command[1]);
            int col1 = Integer.parseInt(command[2]);
            int row2 = Integer.parseInt(command[3]);
            int col2 = Integer.parseInt(command[4]);

            if (row1 >= 0 && row1 >= matrix.length
                    || col1 <= 0 && col1 >= matrix.length
                    || row2 >= 0 && row2 >= matrix.length
                    || col2 <= 0 && col2 >= matrix.length) {
                System.out.println("Invalid input!");

                input = scanner.nextLine();
                continue;
            }

            if (line.equals("swap")) {
                String numToReplace = String.valueOf(matrix[row1][col1]);
                String numToReplace1 = String.valueOf(matrix[row2][col2]);

                matrix[row2][col2] = numToReplace;

                matrix[row1][col1] = numToReplace1;

                for (int row = 0; row < rows; row++) {
                    for (int col = 0; col < cols; col++) {
                        System.out.print(matrix[row][col] + " ");
                    }
                    System.out.println();
                }

            }

            input = scanner.nextLine();
        }

    }
}

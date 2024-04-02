package MultidimensionalArraysExercises;

import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] inputLine = scanner.nextLine().split(" ");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Integer.parseInt(inputLine[col]);
            }
        }
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int bestRow = 0;
        int bestCol = 0;
        for (int row = 0; row < rows - 2; row++) {
            for (int col = 0; col < cols - 2; col++) {

                sum = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2]
                        + matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2]
                        + matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];

//                for (int currentRow = row; currentRow < row + 3; currentRow++) {
//                    for (int currentCol = col; currentCol < col + 3; currentCol++) {
//                        sum += matrix[currentRow][currentCol];
//                    }
//                }

                if (sum > maxSum) {
                    maxSum = sum;
                    bestRow = row;
                    bestCol = col;

                }
            }
        }
        System.out.println("Sum = " + maxSum);

        for (int r = bestRow; r < bestRow + 3; r++) {
            for (int c = bestCol; c < bestCol + 3; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }

    }
}

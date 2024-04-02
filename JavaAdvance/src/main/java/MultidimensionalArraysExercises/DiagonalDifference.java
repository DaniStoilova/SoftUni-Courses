package MultidimensionalArraysExercises;

import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][n];

        for (int row = 0; row < n; row++) {
            String[] input = scanner.nextLine().split(" ");
            for (int col = 0; col < n; col++) {
                matrix[row][col] = Integer.parseInt(input[col]);
            }
        }
        int primarySumDiagonal = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (row == col){
                    primarySumDiagonal += matrix[row][col];
                }
            }
        }


//        for (int index = 0; index < n; index++) {
//            primarySumDiagonal += matrix[index][index];
//        }
//

        int secondaryDiagonal = 0;
        for (int row = n - 1; row >= 0 ; row--) {
            for (int col = 0; col < n; col++) {
                secondaryDiagonal += matrix[row][col];
                row--;

            }
        }
//        for(int row = n - 1, col = 0; col < n && row >= 0 ; row--,col++)  {
//            secondaryDiagonal += matrix[row][col];
//        }
        System.out.println(Math.abs(primarySumDiagonal - secondaryDiagonal));
    }
}

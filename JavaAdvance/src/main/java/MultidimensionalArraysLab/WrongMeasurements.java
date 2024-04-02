package MultidimensionalArraysLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays
                    .stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

        }

        int[] index = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int numToReplace = matrix[index[0]][index[1]];

        List<int[]> list = new ArrayList<>();
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == numToReplace) {
                    int value = getSum(matrix, r, c,numToReplace);
                    list.add(new int[]{r,c,value});

                }


            }
        }
        for (int[] element : list) {
            int row = element[0];
            int col = element[1];
            matrix[row][col] = element[2];
        }
        for (int[] i : matrix) {
            for (int element : i) {
                System.out.print(element + " ");
            }
            System.out.println();
        }



    }

    private static int getSum(int[][] matrix, int r, int c,int numToReplace) {
        int sum = 0;
        if(isInRange(matrix,r + 1,c) && matrix[r + 1][c] != numToReplace) {
            sum += matrix[r + 1][c];
        }
        if(isInRange(matrix,r - 1,c) && matrix[r - 1][c] != numToReplace){
            sum += matrix[r - 1][c];
        }

        if(isInRange(matrix,r,c + 1) && matrix[r][c + 1] != numToReplace){
            sum += matrix[r][c + 1];
        }

        if(isInRange(matrix,r,c - 1) && matrix[r][c - 1] != numToReplace){
            sum += matrix[r][c - 1];
        }

        return sum;

    }


    private static boolean isInRange(int[][] matrix, int r, int c) {

        return r >= 0 && r < matrix.length  && c >= 0 && c < matrix[r].length ;

    }
}

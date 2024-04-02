package MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimentions = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimentions[0];
        int colm = dimentions[1];

        int[][] matrix = new int[rows][colm];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays
                    .stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

        }
        int numberToSearch = Integer.parseInt(scanner.nextLine());

        boolean isFound = false;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                int current = matrix[r][c];
                if(current == numberToSearch){
                    System.out.println(r + " " + c);
                    isFound = true;
                }

            }

        }
        if(!isFound){
            System.out.println("not found");
        }

    }
}

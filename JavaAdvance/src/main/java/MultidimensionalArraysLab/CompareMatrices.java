package MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimentions = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimentions[0];
        int colm = dimentions[1];

        int[][] firstMatrix = new int[rows][colm];

        for (int i = 0; i < rows; i++) {
            int[] arr = Arrays
                    .stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            firstMatrix[i] = arr;
        }

        dimentions = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        rows = dimentions[0];
        colm = dimentions[1];

        int[][] secondMatrix = new int[rows][colm];

        for (int i = 0; i < rows; i++) {
            int[] arr = Arrays
                    .stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            secondMatrix[i] = arr;
        }


        boolean areEqual = firstMatrix.length == secondMatrix.length;
        if (areEqual) {

            areEqual = AreArraysEqual(firstMatrix, secondMatrix);
        }
        System.out.println(areEqual ? "equal" : "not equal");
    }

    private static boolean AreArraysEqual(int[][] firstMatrix, int[][] secondMatrix) {
        boolean areEqual = true;
        for (int r = 0; r < firstMatrix.length; r++) {

            int[] firstArr = firstMatrix[r];
            int[] secondArr = secondMatrix[r];


            if (firstArr.length != secondArr.length) {
                return false;
            }
            for (int i = 0; i < firstArr.length; i++) {
                int firstNum = firstArr[i];
                int secondNum = secondArr[i];
                if (firstNum != secondNum) {
                    return false;
                }
            }
        }
        return areEqual;
    }

    public static void printMatrix(int[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
//        for (int[] arr:matrix) {
//            for (int num:arr) {
//                System.out.print(num + " ");
//            }
//            System.out.println();
//        }


    }
}

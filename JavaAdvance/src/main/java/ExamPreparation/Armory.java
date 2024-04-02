package ExamPreparation;

import java.util.Scanner;

public class Armory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[n][n];

        int row = 0;
        int col = 0;

        for (int i = 0; i < n; i++) {
            char[] data = scanner.nextLine().toCharArray();
            matrix[i] = data;

        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 'A') {
                    row = i;
                    col = j;
                }

            }
        }

        String command = scanner.nextLine();

        int sword = 0;
        boolean isFinish = false;

        while (command != null) {

            if (command.equals("up") && !isOutOfBounds(matrix, row, col)) {
                matrix[row][col] = '-';
                row--;


            } else if (command.equals("down") && !isOutOfBounds(matrix, row, col)) {
                matrix[row][col] = '-';
                row++;


            } else if (command.equals("right") && !isOutOfBounds(matrix, row, col)) {
                matrix[row][col] = '-';
                col++;


            } else if (command.equals("left") && !isOutOfBounds(matrix, row, col)) {
                matrix[row][col] = '-';
                col--;


            }
            if (isOutOfBounds(matrix,row,col)) {
                isFinish = true;
                break;
            }

            if (Character.isDigit(matrix[row][col])) {
                sword += Character.getNumericValue(matrix[row][col]);
                matrix[row][col] = 'A';
            } else if (matrix[row][col] == 'M') {
                matrix[row][col] = '-';
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (matrix[i][j] == 'M') {
                            matrix[i][j] = 'A';
                            row = i;
                            col = j;
                            break;
                        }
                    }
                }


            }
            if (sword >= 65) {
                break;
            }


            command = scanner.nextLine();


        }
        if (!isFinish && sword >= 65) {
            System.out.println("Very nice swords, I will come back for more!");
        } else {
            System.out.println("I do not need more swords!");

        }

        System.out.printf("The king paid %d gold coins.%n", sword);

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }

    }

    private static boolean isOutOfBounds(char[][] matrix, int r, int c) {
        return r < 0 || r >= matrix.length || c < 0 || c >= matrix[r].length;
    }
}

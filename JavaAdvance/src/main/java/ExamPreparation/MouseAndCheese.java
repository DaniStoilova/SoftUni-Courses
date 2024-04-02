package ExamPreparation;

import java.util.Scanner;

public class MouseAndCheese {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[n][n];

        for (int r = 0; r < n; r++) {
            char[] data = scanner.nextLine().toCharArray();
            matrix[r] = data;

        }

        int row = 0;
        int col = 0;

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (matrix[r][c] == 'M') {
                    row = r;
                    col = c;
                }
            }
        }
        String command = scanner.nextLine();

        int countCheeses = 0;

        while (!command.equals("end")) {

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
            if (isOutOfBounds(matrix, row, col)) {
                System.out.println("Where is the mouse?");
                break;
            }
            if (matrix[row][col] == 'c') {
                countCheeses++;

            }
            if (matrix[row][col] == 'B') {
                continue;

            }

            matrix[row][col] = 'M';

            if (countCheeses > 5) {
                break;
            }

            command = scanner.nextLine();
        }
        if (countCheeses > 5) {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", countCheeses);
        } else {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - countCheeses);
        }


        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }


    }

    private static boolean isOutOfBounds(char[][] matrix, int row, int col) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }
}


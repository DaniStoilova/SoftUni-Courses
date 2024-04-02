package ExamPreparation;

import java.util.Scanner;

public class FormulaOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int countCommands = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[n][n];

        for (int r = 0; r < n; r++) {
            char[] data = scanner.nextLine().toCharArray();
            matrix[r] = data;
        }
        int row = 0;
        int col = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 'P') {
                    row = i;
                    col = j;
                }
            }
        }
        boolean isFinish = false;


        while (countCommands-- > 0) {
            String command = scanner.nextLine();
            int nextR= row;
            int nextC= col;

            if (command.equals("up") && !isOutOfBounds(matrix, row, col)) {
                matrix[row][col] = '.';
                row--;
            } else if (command.equals("down") && !isOutOfBounds(matrix, row, col)) {
                matrix[row][col] = '.';
                row++;
            } else if (command.equals("right") && !isOutOfBounds(matrix, row, col)) {
                matrix[row][col] = '.';
                col++;
            } else if (command.equals("left") && !isOutOfBounds(matrix, row, col)) {
                matrix[row][col] = '.';
                col--;
            }
            if (isOutOfBounds(matrix, row, col)) {
                if (command.equals("up")) {
                    row = matrix.length - 1;
                    col = col;
                    matrix[row][col] = 'P';
                } else if (command.equals("down")) {
                    row = 0;
                    col = col;
                    matrix[row][col] = 'P';
                } else if (command.equals("right")) {
                    row = row;
                    col = 0;
                    matrix[row][col] = 'P';
                } else if (command.equals("left")) {
                    row = row;
                    col = matrix[row].length - 1;
                    matrix[row][col] = 'P';
                }

            }

            if (matrix[row][col] == 'B') {
                row = row + 1;
                col = col;
                continue;
            }else if (matrix[row][col] == 'T') {
                row = nextR;
                col = nextC;


            }else if (matrix[row][col] == 'F') {
                matrix[row][col] = 'P';
                isFinish = true;
                break;
            }
            matrix[row][col] = 'P';


        }
        if (isFinish) {
            System.out.println("Well done, the player won first place!");
        } else {
            System.out.println("Oh no, the player got lost on the track!");
        }

        printMatrix(n, matrix);


    }

    private static boolean isOutOfBounds(char[][] matrix, int row, int col) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }

    private static void printMatrix(int n, char[][] matrix) {
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }
}

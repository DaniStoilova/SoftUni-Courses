package ExamPreparation;

import java.util.Scanner;

public class StickyFingers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[] command = scanner.nextLine().split(",");

        String[][] matrix = new String[n][n];

        int row = 0;
        int col = 0;

        for (int r = 0; r < n; r++) {
            String[] data = scanner.nextLine().split(" ");
            matrix[r] = data;

        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j].equals("D")) {
                    row = i;
                    col = j;

                }
            }
        }
        int sum = 0;
        int total = 0;
        boolean isFinish = false;


        for (int i = 0; i < command.length; i++) {
            int nextR = row;
            int nextC = col;


            switch (command[i]) {
                case "right":
                    if (!isOutOfBounds(matrix, row, col)) {
                        matrix[row][col] = "+";
                        col++;
                    }
                    break;
                case "left":
                    if (!isOutOfBounds(matrix, row, col)) {
                        matrix[row][col] = "+";
                        col--;
                    }
                    break;
                case "up":
                    if (!isOutOfBounds(matrix, row, col)) {
                        matrix[row][col] = "+";
                        row--;
                    }
                    break;
                case "down":
                    if (!isOutOfBounds(matrix, row, col)) {
                        matrix[row][col] = "+";
                        row++;
                    }
                    break;

            }
            if (isOutOfBounds(matrix,row,col)){
                row = nextR;
                col = nextC;
                System.out.println("You cannot leave the town, there is police outside!");
            }

            if (matrix[row][col].equals("$")) {
                sum = row * col;
                total += sum;
                matrix[row][col] = "+";
                System.out.printf("You successfully stole %d$.%n", sum);

            }
            if (matrix[row][col].equals("P")) {
                System.out.printf("You got caught with %d$, and you are going to jail%n", total);
                matrix[row][col] = "#";
                isFinish = true;
                break;
            }
            matrix[row][col] = "D";
        }
        if (!isFinish) {
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", total);
        }

        printMatrix(n, matrix);

    }

    private static boolean isOutOfBounds(String[][] matrix, int row, int col) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }

    private static void printMatrix(int n, String[][] matrix) {
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }
}

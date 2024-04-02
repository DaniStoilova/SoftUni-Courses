package ExamPreparation;

import java.util.Scanner;

public class CookingJourney {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[n][n];

        for (int i = 0; i < n; i++) {
            char[] data = scanner.nextLine().toCharArray();
            matrix[i] = data;
        }
        int row = 0;
        int col = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 'S') {
                    row = i;
                    col = j;
                }
            }
        }

        String command = scanner.nextLine();
        boolean isFinish = false;
        int money = 0;

        while (command != null) {
            if (command.equals("up") && !isOfOutBounds(matrix, row, col)) {
                matrix[row][col] = '-';
                row--;
            } else if (command.equals("down") && !isOfOutBounds(matrix, row, col)) {
                matrix[row][col] = '-';
                row++;
            } else if (command.equals("right") && !isOfOutBounds(matrix, row, col)) {
                matrix[row][col] = '-';
                col++;
            } else if (command.equals("left") && !isOfOutBounds(matrix, row, col)) {
                matrix[row][col] = '-';
                col--;
            }
            if (isOfOutBounds(matrix,row,col)){
                isFinish = true;
                break;
            }

            if (matrix[row][col] == 'P'){
                matrix[row][col] = '-';
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (matrix[i][j] == 'P'){
                            matrix[i][j] = 'S';
                            row = i;
                            col = j;
                            break;
                        }
                    }
                }

            }else if (Character.isDigit(matrix[row][col])){
                money += Character.getNumericValue(matrix[row][col]);
                matrix[row][col] = 'S';
            }
            if (money >= 50){
                break;
            }

            command = scanner.nextLine();
        }
        if (!isFinish && money >= 50){
            System.out.println("Good news! You succeeded in collecting enough money!");
            System.out.printf("Money: %d%n",money);
        }else{
            System.out.println("Bad news! You are out of the pastry shop.");
            System.out.printf("Money: %d%n",money);
        }


        printMatrix(n,matrix);


    }


    private static void printMatrix(int n, char[][] matrix) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean isOfOutBounds(char[][] matrix, int row, int col) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }
}

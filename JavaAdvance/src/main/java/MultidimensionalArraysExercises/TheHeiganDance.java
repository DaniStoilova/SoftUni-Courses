package MultidimensionalArraysExercises;

import java.util.Scanner;

public class TheHeiganDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double damage = Double.parseDouble(scanner.nextLine());
        double pointsHeidan = 3000000.0;
        int playerPoints = 18500;
        int cloud = 3500;
        int eruption = 6000;

        int row = 7;
        int col = 7;

        String spell = "";
        boolean isCloud = false;

        while (playerPoints > 0 && pointsHeidan > 0) {
            pointsHeidan -= damage;

            if (isCloud) {
                playerPoints -= cloud;
                isCloud = false;
                if (playerPoints < 0) {
                    break;
                }
            }
            if (pointsHeidan < 0) {
                break;
            }

            String[] data = scanner.nextLine().split(" ");

            String command = data[0];
            int r = Integer.parseInt(data[1]);
            int c = Integer.parseInt(data[2]);


            boolean[][] matrix = new boolean[15][15];
            for (int i = r - 1; i <= r + 1; i++) {
                if (i >= 0 && i < matrix.length) {
                    for (int j = c - 1; j <= c + 1; j++) {
                        if (j >= 0 && j < matrix[r].length) {
                            matrix[i][j] = true;

                        }
                    }
                }

            }

            if (matrix[row][col]) {
                if (!isOutOfBounds(matrix, row - 1, col) && !matrix[row - 1][col]) {
                    row--;
                } else if (!isOutOfBounds(matrix, row + 1, col) && !matrix[row + 1][col]) {
                    row++;
                } else if (!isOutOfBounds(matrix, row, col + 1) && !matrix[row][col + 1]) {
                    col++;
                } else if (!isOutOfBounds(matrix, row, col - 1) && !matrix[row][col - 1]) {
                    col--;
                }

                if (matrix[row][col] && command.equals("Cloud")) {
                    playerPoints -= cloud;
                    isCloud = true;
                    spell = "Plague Cloud";
                } else if (matrix[row][col] && command.equals("Eruption")) {
                    playerPoints -= eruption;
                    spell = command;
                }
            }
        }

        if (pointsHeidan > 0) {
            System.out.printf("Heigan: %.2f%n", pointsHeidan);
        } else {
            System.out.println("Heigan: Defeated!");
        }
        if (playerPoints > 0) {
            System.out.printf("Player: %d%n", playerPoints);
        } else {
            System.out.println("Player: Killed by " + spell);
        }

        System.out.println("Final position: " + row + ", " + col);
    }

    private static boolean isOutOfBounds(boolean[][] matrix, int row, int col) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }
}

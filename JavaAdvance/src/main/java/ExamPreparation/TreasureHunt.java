package ExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] dimentions = scanner.nextLine().split(" ");

        int row = Integer.parseInt(dimentions[0]);
        int col = Integer.parseInt(dimentions[1]);

        char[][] matrix = new char[row][col];

        int huntRow = 0;
        int huntCol = 0;

        for (int r = 0; r < row; r++) {
            String [] data = scanner.nextLine().split(" ");
            for (int c = 0; c < col ; c++) {
                matrix[r][c] = data[c].charAt(0);

            }
        }

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (matrix[r][c] == 'Y'){
                    huntRow = r;
                    huntCol = c;
                }

            }
        }

        String input = scanner.nextLine();


        List<String> list = new ArrayList<>();
        while (!input.equals("Finish")){


            if (input.equals("right") && huntCol + 1 < col && matrix[huntRow][huntCol + 1] != 'T'){
                huntCol++;
                list.add(input);
            }else if (input.equals("left") && huntCol - 1 >= 0 && matrix[huntRow][huntCol - 1] != 'T'){
                huntCol--;
                list.add(input);
            }else if (input.equals("up") && huntRow - 1 >= 0 && matrix[huntRow - 1][huntCol] != 'T'){
                huntRow--;
                list.add(input);
            }else if (input.equals("down") && huntRow + 1 < row && matrix[huntRow + 1][huntCol] != 'T'){
                huntRow++;
                list.add(input);
            }else{
                matrix[huntRow][huntCol] = 'Y';

            }

            if (matrix[huntRow][huntCol] == 'T'){

                return;
            }


            input = scanner.nextLine();

        }
        if (matrix[huntRow][huntCol] == 'X'){
            System.out.println("I've found the treasure!");
            System.out.print("The right path is " + String.join(", ",list));
        }else{
            System.out.println("The map is fake!");
        }



//        for (int r = 0; r < row; r++) {
//            for (int c = 0; c < col; c++) {
//                System.out.print(matrix[r][c]);
//            }
//            System.out.println();
//        }


    }
}

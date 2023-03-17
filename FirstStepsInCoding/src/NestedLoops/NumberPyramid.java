package NestedLoops;

import java.util.Scanner;

public class NumberPyramid {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

    boolean flag = false;

    int number = Integer.parseInt(scanner.nextLine());

    int currentNember = 0;
            // redove
    for (int rows=1; rows <= number; rows++){

        for (int columns = 1; columns <= rows; columns++){
                currentNember++;
                if(currentNember > number){
                    flag = true;
                    break;
                }
                System.out.print(currentNember + " ");
        }
        if (flag){
            break;
        }
        System.out.println();

    }
    }
}

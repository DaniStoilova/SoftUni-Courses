package MethodsExersises;

import java.util.Scanner;

public class CharactersInRange {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        char symbol1 = scanner.nextLine().charAt(0);
        char symbol2 = scanner.nextLine().charAt(0);


        printSequenceOfChar(symbol1,symbol2);
    }

    private static void printSequenceOfChar(char symbol1, char symbol2) {
        if (symbol1 < symbol2){
            for (char i = (char)(symbol1 + 1); i < symbol2 ; i++) {
              System.out.print(i + " ");
            }
        }else{
            for (char i = (char)(symbol2 + 1); i < symbol1 ; i++) {
                System.out.print(i + " ");
            }
        }
    }
}

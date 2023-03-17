package DataTypesAndVariables;

import java.util.Scanner;

public class ReversedChars {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);


        char first = scanner.nextLine().charAt(0);
        char second = scanner.nextLine().charAt(0);
        char third = scanner.nextLine().charAt(0);

        System.out.printf("%c %c %c",third,second,first);

//        String data = "";
//        for (int i = 0; i < 3; i++) {
//            char symbol = scanner.nextLine().charAt(0);
//        data = data + symbol;
//
//        }
//
//        for (int i = data.length() - 1; i >= 0 ; i--) {
//            System.out.print(data.charAt(i) + " ");
//
//        }


    }
}

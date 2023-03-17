package DataTypesAndVariablesExercise;

import java.util.Scanner;

public class PrintPartOfASCIITable {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);


        int startNumber = Integer.parseInt(scanner.nextLine());
        int endNumber = Integer.parseInt(scanner.nextLine());


        for (int i = startNumber; i <= endNumber ; i++) {
          //  char symbol = (char) i;
            System.out.print((char) i + " ");
             //System.out.printf("%c ",i);

        }
    }
}

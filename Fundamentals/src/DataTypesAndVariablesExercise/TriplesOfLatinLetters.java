package DataTypesAndVariablesExercise;

import java.util.Scanner;

public class TriplesOfLatinLetters {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

    int n = Integer.parseInt(scanner.nextLine());

        for (char firstChar = 'a'; firstChar < 'a' + n ; firstChar++) {
            for (char secondChar = 'a'; secondChar <'a' + n; secondChar++) {
                for (char thirdChar = 'a'; thirdChar < 'a' + n; thirdChar++) {

                    System.out.printf("%c%c%c%n", firstChar, secondChar, thirdChar);
                }
            }
        }
    }
}

package TextProcessingExercise;

import java.util.Scanner;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputLine = scanner.nextLine();

        String result = "";
        char symbol = inputLine.charAt(0);

        result += symbol;

        for (int i = 0; i < inputLine.length(); i++) {
            char currentSymbol = inputLine.charAt(i);
            if (symbol != currentSymbol) {

                result += currentSymbol;
                symbol = currentSymbol;
            }

        }

        System.out.println(result);


    }
}

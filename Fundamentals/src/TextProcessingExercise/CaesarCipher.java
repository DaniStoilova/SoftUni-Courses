package TextProcessingExercise;

import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        StringBuilder encryptedText = new StringBuilder();
        for (int i = 0; i <= text.length() - 1; i++) {
            char symbol = text.charAt(i);

            char encryptSymbol = (char) (symbol + 3);

            encryptedText.append(encryptSymbol);
        }
        System.out.println(encryptedText);
    }
}

package ExamPreparation;

import java.util.Scanner;

public class TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String input = scanner.nextLine();

        StringBuilder builder = new StringBuilder(text);

        while (!input.equals("Decode")) {

            if (input.contains("Move")) {
                int numLetters = Integer.parseInt(input.split("\\|")[1]);

                builder.append(builder,0,numLetters);
                builder.delete(0,numLetters);

            } else if (input.contains("Insert")) {
                int index = Integer.parseInt(input.split("\\|")[1]);
                String symbol = input.split("\\|")[2];

                builder.insert(index, symbol);


            } else if (input.contains("ChangeAll")) {
                String symbol = input.split("\\|")[1];
                String symbolText = input.split("\\|")[2];

                if (text.contains(symbol)) {
                    String update = builder.toString().replace(symbol, symbolText);

                    builder = new StringBuilder(update);

                }


            }


            input = scanner.nextLine();
        }

        System.out.printf("The decrypted message is: %s", builder);
    }
}

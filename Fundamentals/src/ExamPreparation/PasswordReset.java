package ExamPreparation;

import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String input = scanner.nextLine();



        while (!input.equals("Done")) {
            String[] commandLine = input.split(" ");
            String command = commandLine[0];

            switch (command) {
                case "TakeOdd":

                    StringBuilder stringBuilder = new StringBuilder();
                    for (int i = 1; i < text.length(); i++) {
                        char symbol = text.charAt(i);
                        if (i % 2 == 1) {

                            stringBuilder.append(symbol);
                        }
                    }
                    text = stringBuilder.toString();

                    System.out.println(text);

                    break;
                case "Cut":
                    int index = Integer.parseInt(commandLine[1]);
                    int length = index + Integer.parseInt(commandLine[2]);

                     text = new StringBuilder(text).delete(index,length).toString();

                    System.out.println(text);


                    break;
                case "Substitute":
                    String substring = commandLine[1];
                    String substitute = commandLine[2];

                    if (text.contains(substring)) {

                        text = text.replace(substring, substitute);


                        System.out.println(text);


                    } else {
                        System.out.println("Nothing to replace!");
                    }


                    break;
            }

            input = scanner.nextLine();


        }
        System.out.printf("Your password is: %s", text);
    }
}

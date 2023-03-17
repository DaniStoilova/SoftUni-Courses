package ExamPreparation;

import java.util.Locale;
import java.util.Scanner;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String activationKey = scanner.nextLine();

        String input = scanner.nextLine();

        while (!input.equals("Generate")) {
            String[] command = input.split(">>>");
            String commandLine = command[0];
            String substring = "";
            int startIndex = 0;
            int endIndex = 0;
            switch (commandLine) {
                case "Contains":
                    substring = command[1];
                    if (activationKey.contains(substring)) {
                        System.out.printf("%s contains %s%n", activationKey, substring);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    String upperOrLower = command[1];
                    startIndex = Integer.parseInt(command[2]);
                    endIndex = Integer.parseInt(command[3]);

                    substring = activationKey.substring(startIndex, endIndex);
                    if (upperOrLower.equals("Upper")) {
                        activationKey = activationKey.replace(substring, substring.toUpperCase());

                    } else if (upperOrLower.equals("Lower")) {
                        activationKey = activationKey.replace(substring, substring.toLowerCase());


                    }
                    System.out.println(activationKey);

                    break;
                case "Slice":
                    startIndex = Integer.parseInt(command[1]);
                    endIndex = Integer.parseInt(command[2]);


                    substring = activationKey.substring(startIndex, endIndex);

                    activationKey = activationKey.replace(substring, "");

                    System.out.println(activationKey);


                    break;
            }

            input = scanner.nextLine();
        }
        System.out.printf("Your activation key is: %s%n", activationKey);

    }
}

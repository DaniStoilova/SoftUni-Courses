package ExamPreparation;

import java.util.Scanner;

import static java.lang.String.valueOf;

public class SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String input = scanner.nextLine();



        while (!input.equals("Reveal")) {
            String[] command = input.split(":\\|:");
            String commandLine = command[0];

            switch (commandLine) {
                case "InsertSpace":
                    int index = Integer.parseInt(command[1]);

                   // StringBuilder builder1 = new StringBuilder(text);

                    text = text.substring(0, index) + " " + text.substring(index);
//                    builder1.insert(index," ");
//
//                    text = builder1.toString();

                    System.out.println(text);

                    break;
                case "Reverse":
                    String substringReverse = command[1];

                    StringBuilder builder = new StringBuilder(substringReverse);

                    if (text.contains(substringReverse)) {

                        text = text.replace(substringReverse, builder.reverse().toString());


                        System.out.println(text);
                    } else {
                        System.out.println("error");
                    }


                    break;
                case "ChangeAll":
                    String substringChangeAll = command[1];
                    String replacementChangeAll = command[2];

                    text = text.replace(substringChangeAll, replacementChangeAll);

                    System.out.println(text);

                    break;
            }


            input = scanner.nextLine();
        }
        System.out.printf("You have a new text message: %s", text);

    }
}

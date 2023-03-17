package NewFinalExam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String input = scanner.nextLine();

        while (!input.equals("Complete")) {
            String[] command = input.split(" ");
            String commandLine = command[0];

            switch (commandLine) {
                case "Make":
                    String upperOrLower = command[1];

                    if (upperOrLower.equals("Upper")) {

                        String substring = text.substring(0, text.length());

                        text = text.replace(substring, substring.toUpperCase());

                        System.out.println(text);

                    } else if (upperOrLower.equals("Lower")) {

                        String substring = text.substring(0, text.length());

                        text = text.replace(substring, substring.toLowerCase());

                        System.out.println(text);

                    }


                    break;


                case "GetDomain":
                    int count = Integer.parseInt(command[1]);

                    String substring = text.substring(text.length() - count);

                    System.out.println(substring);

                    break;
                case "GetUsername":

                    if (text.contains("@")) {
                        int index = text.indexOf("@");

                        String substring1 = text.substring(0, index);


                        System.out.println(substring1);

                    } else {
                        System.out.printf("The email %s doesn't contain the @ symbol.%n", text);

                    }

                    break;
                case "Replace":
                    char symbol = command[1].charAt(0);

                    String sub = text.replace(symbol,'-');

                    System.out.println(sub);


                    break;
                case "Encrypt":

                    StringBuilder builder = new StringBuilder(text);

                    List <Integer> num = new ArrayList<>();
                    for (int i = 0; i < builder.length(); i++) {
                        char s = builder.charAt(i);

                        int number = (int) (char) s;

                        num.add(number);




                    }
                    for (int n:num) {
                        System.out.print(n + " ");
                    }







                    break;
            }


            input = scanner.nextLine();
        }


    }
}

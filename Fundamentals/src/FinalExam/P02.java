package FinalExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String regex = "^([$%])(?<name>[A-Za-z]{3,})\\1:\\s?" +
                "(\\[(?<first>[0-9]+)\\])\\|(\\[(?<second>[0-9]+)\\])\\|(\\[(?<third>[0-9]+)\\])\\|$";

        Pattern pattern = Pattern.compile(regex);


        for (int i = 0; i < n; i++) {
            String message = scanner.nextLine();

            Matcher matcher = pattern.matcher(message);

            if (matcher.find()) {
                String tag = matcher.group("name");
                int num1 = Integer.parseInt(matcher.group("first"));
                int num2 = Integer.parseInt(matcher.group("second"));
                int num3 = Integer.parseInt(matcher.group("third"));

                char symbol1 = (char) num1;
                char symbol2 = (char) num2;
                char symbol3 = (char) num3;


                System.out.printf("%s: %c%c%c%n", tag, symbol1, symbol2, symbol3);


            } else if (!matcher.find()) {
                System.out.println("Valid message not found!");
            }


        }


    }


}

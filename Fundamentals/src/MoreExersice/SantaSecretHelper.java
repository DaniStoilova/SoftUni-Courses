package MoreExersice;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SantaSecretHelper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();

        String regex = "([@])(?<childname>[A-Za-z]+)([^\\@\\!\\-\\:\\>])*([!])(?<childbehavior>[A-Z])\\4";

        Pattern pattern = Pattern.compile(regex);


        while (!input.equals("end")) {

            StringBuilder stringBuilder = new StringBuilder();

            for (char symbol : input.toCharArray()) {
                char newSymbol = (char) (symbol - n);

                stringBuilder.append(newSymbol);



            }

            String decryption = stringBuilder.toString();

            Matcher matcher = pattern.matcher(decryption);

            if (matcher.find()) {
                String name = matcher.group("childname");
                String behavior = matcher.group("childbehavior");

                if (behavior.contains("G")) {

                    System.out.println(name);

                }


            }


            input = scanner.nextLine();
        }


    }
}

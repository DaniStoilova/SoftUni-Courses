package RegularExpressionsExercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
            //support@github.com
        String regex = "(?<users>[A-Za-z0-9]+[._-]?[A-Za-z0-9]+)@(?<host>[A-Za-z]+-?[A-Za-z]+)(\\.(?<host1>[A-Za-z]+-?)[A-Za-z]+)+";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {

            System.out.println(matcher.group());
        }


    }
}

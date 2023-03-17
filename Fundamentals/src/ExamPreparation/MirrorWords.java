package ExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String text = scanner.nextLine();

        String regex = "(@|#)(?<first>[A-za-z]{3,})\\1\\1(?<second>[A-za-z]{3,})\\1";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(text);

        List<String> list = new ArrayList<>();

        int allCount = 0;
        while (matcher.find()) {
            String firstWord = matcher.group("first");
            String secondWord = matcher.group("second");
            allCount++;
            StringBuilder secondBuilder = new StringBuilder(secondWord);
            String reversedSecondWord = secondBuilder.reverse().toString();

            if (firstWord.equals(reversedSecondWord)) {

                list.add(firstWord + " <=> " + secondWord);

            }

        }
        if (allCount == 0) {
            System.out.println("No word pairs found!");
        } else {
            System.out.println(allCount + " word pairs found!");
        }


        if (list.size() == 0) {
            System.out.println("No mirror words!");
        } else {
            System.out.println("The mirror words are:");
            System.out.println(String.join(", ", list));
        }


    }
}

package ExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String regexDigit = "[0-9]";

        String regex = "([:]{2}|[*]{2})([A-Z][a-z]{2,})\\1";

        Pattern patternDigit = Pattern.compile(regexDigit);

        Pattern pattern = Pattern.compile(regex);

        Matcher matcherDigit = patternDigit.matcher(input);

        List<String> list = new ArrayList<>();

        List<String> listEmoji = new ArrayList<>();

        int sum = 1;
        while (matcherDigit.find()) {
            int digit = Integer.parseInt(matcherDigit.group(0));

            sum *= digit;

        }

        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {

            String emoji = matcher.group();

            list.add(emoji);


            int total = 0;
            for (char symbol : emoji.toCharArray()) {
                if (Character.isLetter(symbol)) {
                    total += symbol;
                }

            }
            if (total >= sum) {

                listEmoji.add(emoji);
            } else {

            }

        }
        System.out.printf("Cool threshold: %d%n", sum);
        System.out.printf("%d emojis found in the text. The cool ones are:%n", list.size());
        for (String item : listEmoji) {
            System.out.println(item + " ");

        }
    }

}


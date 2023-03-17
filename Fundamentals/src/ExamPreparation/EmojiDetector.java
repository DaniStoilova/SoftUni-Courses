package ExamPreparation;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] arr = input.split(" ");

        String regex = "([:]{2}|[*]{2})([A-Z][a-z]{2,})\\1";

        Pattern pattern = Pattern.compile(regex);

        int count = 0;
        long sum = 1;

        List<String> list = new ArrayList<>();

        for (char symbol : input.toCharArray()) {
            if (Character.isDigit(symbol)) {
                sum *= Integer.parseInt(String.valueOf(symbol));

            }

        }
        for (int i = 0; i < arr.length; i++) {
            Matcher matcher = pattern.matcher(arr[i]);
            while (matcher.find()) {

                String name = matcher.group();

                count++;



                int total = 0;
                for (char c : name.toCharArray()) {
                    if (Character.isLetter(c)) {
                        total += c;
                    }

                }
                if (total >= sum){

                    list.add(name);
                }else {

                }

            }
        }
        System.out.printf("Cool threshold: %d%n", sum);
        System.out.printf("%d emojis found in the text. The cool ones are:%n", count);
        {
            for (String item : list) {
                System.out.println(item + " ");
            }

        }
    }
}




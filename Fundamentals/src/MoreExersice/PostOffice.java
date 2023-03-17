package MoreExersice;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PostOffice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

      String[] text = scanner.nextLine().split("\\|");

      String first = text[0];
      String second = text[1];
      String third = text[2];

      String regexFirst = "([#$%*&])([A-Z]+)(\\1)";

        Pattern pattern = Pattern.compile(regexFirst);

        Matcher matcherFirst = pattern.matcher(first);

        String word = "";
        while (matcherFirst.find()){
            String current = matcherFirst.group();

            word = current.substring(1,current.length() - 1);

            System.out.println(word);

        }

        String regexSecond = "([0-9]{2}):([0-9]{2})";

        Pattern pattern1 = Pattern.compile(regexSecond);

        Matcher matcherSecond = pattern1.matcher(second);

        while (matcherSecond.find()){

            






        }








    }
}

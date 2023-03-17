package MoreExersice;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TreasureFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

         int [] key = Arrays.stream(scanner.nextLine().split(" "))
                 .mapToInt(Integer::parseInt).toArray();

        String input = scanner.nextLine();
        String  line = "";
        while (!input.equals("find")) {
            String newLine = input;

            int keyL = 0;
            for (int i = 0; i < newLine.length(); i++) {
                int symbol = (int) (newLine.charAt(i)) - key[keyL];

                line += (char) (char) symbol;

                keyL++;

                if (keyL == key.length){

                    keyL = 0;
                }
            }

            input = scanner.nextLine();



            String text = line;

            line = "";

            //String regex = ".*([&])(?<type>[a-zA-Z]*)([&]).*([<])(?<coordinates>.*)([>])";
            String regex = ".*&(?<type>[A-Za-z]+)&.*\\<(?<coordinates>[A-Za-z0-9]+)\\>.*";

            Pattern pattern = Pattern.compile(regex);

            Matcher matcher = pattern.matcher(text);

            while (matcher.find()){
               String type = matcher.group("type");
               String coordinates = matcher.group("coordinates");

                System.out.printf("Found %s at %s%n",type,coordinates);

            }



        }

    }
}

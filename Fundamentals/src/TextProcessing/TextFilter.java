package TextProcessing;

import java.util.Scanner;

import static TextProcessing.RepeatStrings.repeatString;

public class TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] banArr = scanner.nextLine().split(", ");

        String text = scanner.nextLine();

        for (String banWord : banArr) {
            if (text.contains(banWord)) {

                text = text.replace(banWord, repeatString("*", banWord.length()));

            }


        }
        System.out.println(text);
    }

    private static String repeatString(String s, int count) {
        String result = "";

        for (int i = 0; i < count; i++) {
            result += s;

        }

        return result;
    }
}

package MoreExersice;

import java.util.Scanner;

public class AsciiSumator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char symbol = scanner.nextLine().charAt(0);
        char symbol1 = scanner.nextLine().charAt(0);
        String text = scanner.nextLine();

        int start = Math.min(symbol,symbol1);
        int end = Math.max(symbol,symbol1);

        int sum = 0;
        for (int i = 0; i < text.length(); i++) {
            char s = text.charAt(i);

            if (s > start && s < end) {

                sum += s;

            }
        }
        System.out.println(sum);
    }
}

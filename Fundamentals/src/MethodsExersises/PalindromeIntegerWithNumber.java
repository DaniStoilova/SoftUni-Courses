package MethodsExersises;

import java.util.Scanner;

public class PalindromeIntegerWithNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String inputline = scanner.nextLine();
        while (!inputline.equals("END")) {
            int num = Integer.parseInt(inputline);

            if (isPalindrome(num)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }

            inputline = scanner.nextLine();
        }

    }

    private static boolean isPalindrome(int number) {
        int sum = 0;
        int startNumber = number;
        while (number > 0) {
            int current = number % 10;
            sum = (sum * 10) + current;
            number /= 10;


        }
        if (startNumber == sum) {
            return true;
        } else {
            return false;
        }
    }
}


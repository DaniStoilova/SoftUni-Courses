package MethodsExersises;

import java.util.Scanner;

public class PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String inputLine = scanner.nextLine();

        while (!inputLine.equals("END")) {
            if (!isPalindrome(inputLine)) {
                System.out.println("false");
            } else {
                System.out.println("true");
            }


            inputLine = scanner.nextLine();


        }


    }

    private static boolean isPalindrome(String num) {
        String reversedString = "";
        for (int i = num.length() - 1; i >= 0; i--) {
            reversedString += num.charAt(i);
        }
        return num.equals(reversedString);
    }


}

package MethodsExersises;

import java.util.Enumeration;
import java.util.Scanner;

public class TopNumber {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int number = 1; number <= n ; number++) {

            if (isSumDigitDivisible(number) && holdOddDigit(number)) {
                System.out.println(number);
            }

        }

    }
    private static boolean isSumDigitDivisible(int number) {
        int sum = 0;
        while (number > 0) {
            int lastDigit = number % 10;
            sum += lastDigit;

            number = number / 10;
        }
        if (sum % 8 == 0) {
            return true;
        } else {
            return false;  // return sum % 8 == 0;
        }
    }
        private static boolean holdOddDigit(int number){
            while (number > 0) {
                int lastDigit = number % 10;

                if (lastDigit % 2 == 1) {
                    return true;
                }
                number = number / 10;
            }
            return false;
        }
    }


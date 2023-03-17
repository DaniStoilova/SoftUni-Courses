package DataTypesAndVariablesMoreExersises;

import java.util.Scanner;

public class PrimeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        for (int num = 2; num <= number; num++) {
            boolean isPrime = true;
            for (int num2 = 2; num2 < num; num2++) {
                if (num % num2 == 0) {
                    isPrime = false;
                    break;
                }
            }
            System.out.printf("%d -> %b%n", num, isPrime);

        }
    }
}

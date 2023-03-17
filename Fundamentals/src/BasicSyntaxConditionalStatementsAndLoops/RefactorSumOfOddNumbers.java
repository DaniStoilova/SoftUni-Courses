package BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class RefactorSumOfOddNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int number = 1;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
             sum += number;
            System.out.println(number);
            number += 2;
        }
        System.out.printf("Sum: %d%n", sum);
    }
}


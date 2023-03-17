package MidExam;

import java.util.Scanner;

public class BlackFlag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int daysOfPlunder = Integer.parseInt(scanner.nextLine());
        int dailyPlunder = Integer.parseInt(scanner.nextLine());
        double expectedPlunder = Double.parseDouble(scanner.nextLine());

        double sum = 0;
        for (int i = 1; i <= daysOfPlunder; i++) {

            sum += dailyPlunder;

            if (i % 3 == 0) {

                sum = sum + (dailyPlunder * 0.5);

            }
            if (i % 5 == 0) {

                sum = sum * 0.70;
            }

        }

        double percentageOfThePlunder = 100 - (((expectedPlunder - sum) / expectedPlunder) * 100);
        if (expectedPlunder <= sum) {
            System.out.printf("Ahoy! %.2f plunder gained.", sum);

        } else {
            System.out.printf("Collected only %.2f%% of the plunder.%n", percentageOfThePlunder);
        }

    }
}


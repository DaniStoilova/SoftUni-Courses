package MoreExercises;

import ForLoop.Oscars;

import java.util.Scanner;

public class ReportSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int budget = Integer.parseInt(scanner.nextLine());

        int total = 0;
        int sumCash = 0;
        int sumPOS = 0;
        int countCash = 0;
        int countPos = 0;
        int countDays = 0;

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            int priceAcc = Integer.parseInt(input);
            countDays++;
            if (countDays % 2 == 0) {
                if (priceAcc <= 10) {
                    System.out.println("Error in transaction!");
                } else {
                    System.out.println("Product sold!");
                    total += priceAcc;
                    sumPOS += priceAcc;
                    countPos++;
                }
            } else {
                if (priceAcc >= 100) {
                    System.out.println("Error in transaction!");
                } else {
                    System.out.println("Product sold!");
                    total += priceAcc;
                    sumCash += priceAcc;
                    countCash++;
                }
            }
                if (total >= budget) {
                    System.out.printf("Average CS: %.2f%n", sumCash * 1.0 / countCash);
                    System.out.printf("Average CC: %.2f", sumPOS * 1.0 / countPos);
                    break;
                }
            input = scanner.nextLine();
        }
        if(input.equals("End")){
            System.out.println("Failed to collect required money for charity.");
        }

    }
}

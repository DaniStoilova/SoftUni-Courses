package AdvanceConditionalStatement;

import java.util.Scanner;

public class Journey {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();

        String holiday = "";
        String destination = "";
        double price = 0;
        if (season.equals("summer")) {
            if (budget <= 100) {
                price = 0.30 * budget;
                holiday = "Camp";
                destination = "Bulgaria";
            } else if (budget <= 1000) {
                price = 0.40 * budget;
                holiday = "Camp";
                destination = "Balkans";
            } else {
                price = 0.9 * budget;
                holiday = "Hotel";
                destination = "Europe";
            }

        } else if (season.equals(("winter"))) {
            if (budget <= 100) {
                price = 0.70 * budget;
                holiday = "Hotel";
                destination = "Bulgaria";
            } else if (budget <= 1000) {
                price = 0.80 * budget;
                holiday = "Hotel";
                destination = "Balkans";
            } else {
                price = 0.9 * budget;
                holiday = "Hotel";
                destination = "Europe";
            }
        }
        System.out.printf("Somewhere in %s%n", destination);
        System.out.printf("%s - %.2f", holiday, price);

    }
}


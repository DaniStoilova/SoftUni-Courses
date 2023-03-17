package BasicSyntaxConditionalStatementsAndLoopsExersises;

import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double sum = 0;
        String input = scanner.nextLine();
        while (!input.equals("Start")) {
            double coins = Double.parseDouble(input);
            if (coins == 0.10 || coins == 0.20 || coins == 0.50 || coins == 1 || coins == 2) {
                sum += coins;
            } else {
                System.out.printf("Cannot accept %.2f%n", coins);

            }
            input = scanner.nextLine();

        }

        String input1 = scanner.nextLine();
        while (!input1.equals("End")) {
            String product = input1;

            double price = 0.0;
            if (product.equals("Nuts")) {
                price = 2.0;
            } else if (product.equals("Water")) {
                price = 0.7;
            } else if (product.equals("Crisps")) {
                price = 1.5;
            } else if (product.equals("Soda")) {
                price = 0.8;
            } else if (product.equals("Coke")) {
                price = 1.0;
            } else {
                System.out.println("Invalid product");

            }

            if (price > 0) {
                if (sum >= price) {
                    sum -= price;
                    System.out.printf("Purchased %s%n", product);
                } else {
                    System.out.printf("Sorry, not enough money%n");
                }
            }
            input1 = scanner.nextLine();

        }
        if (input1.equals("End")) {
            System.out.printf("Change: %.2f%n", sum);
        }

    }
}

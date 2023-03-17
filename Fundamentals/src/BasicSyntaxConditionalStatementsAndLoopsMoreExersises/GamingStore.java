package BasicSyntaxConditionalStatementsAndLoopsMoreExersises;

import java.util.Scanner;

public class GamingStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double currentBalance = Double.parseDouble(scanner.nextLine());
        double total = 0.0;
        String input = scanner.nextLine();
        while (!input.equals("Game Time")) {

            double price = 0.0;
            if (input.equals("OutFall 4")) {
                price = 39.99;
            } else if (input.equals("CS: OG")) {
                price = 15.99;
            } else if (input.equals("Zplinter Zell")) {
                price = 19.99;
            } else if (input.equals("Honored 2")) {
                price = 59.99;
            } else if (input.equals("RoverWatch")) {
                price = 29.99;
            } else if (input.equals("RoverWatch Origins Edition")) {
                price = 39.99;
            } else {
                System.out.println("Not Found");
            }
            total += price;

            if (currentBalance < price) {
                System.out.println("Too Expensive");
            } else if (currentBalance > price && input.equals("OutFall 4") || (input.equals("CS: OG") || input.equals("Zplinter Zell") ||
            input.equals("Honored 2") || input.equals("RoverWatch") || input.equals("RoverWatch Origins Edition"))){
                System.out.printf("Bought %s%n", input);
                currentBalance -= price;
            }

            if (currentBalance == 0) {
                System.out.println("Out of money!");
                break;
            }
            input = scanner.nextLine();
        }
        if (input.equals("Game Time")) {
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f", total, currentBalance);
        }
    }
}

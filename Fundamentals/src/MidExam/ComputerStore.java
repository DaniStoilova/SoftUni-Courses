package MidExam;

import java.util.Scanner;

public class ComputerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();


        double total = 0.0;
        while ((!input.equals("regular")) &&
                (!input.equals("special"))) {
            double price = Double.parseDouble(input);
            total += price;

            if (price < 0) {
                System.out.println("Invalid price!");
                total = total - price;
            }


            input = scanner.nextLine();

        }


        double taxes = total * 0.20;
        double totalSum = total + taxes;

        if (input.equals("special")) {
            totalSum = totalSum * 0.9;
        }

        if (total == 0) {
            System.out.println("Invalid order!");
            return;

        }
        System.out.printf("Congratulations you've just bought a new computer!%n");
        System.out.printf("Price without taxes: %.2f$%n", total);
        System.out.printf("Taxes: %.2f$%n", taxes);
        System.out.printf("-----------%n");
        System.out.printf("Total price: %.2f$%n", totalSum);

    }
}



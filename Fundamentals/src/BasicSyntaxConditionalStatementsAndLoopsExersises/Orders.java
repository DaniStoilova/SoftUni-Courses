package BasicSyntaxConditionalStatementsAndLoopsExersises;

import java.util.Scanner;

public class Orders {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        //daysInMonth * capsulesCount) * pricePerCapsule)
        double coffeePrice = 0;
        double total = 0;
        for (int i = 0; i < n; i++) {
            double	pricePerCapsule = Double.parseDouble(scanner.nextLine());
            int days = Integer.parseInt(scanner.nextLine());
            int capsulesCount  = Integer.parseInt(scanner.nextLine());

            coffeePrice = pricePerCapsule * (days * capsulesCount);

            total += coffeePrice;

            System.out.printf("The price for the coffee is: $%.2f%n",coffeePrice);


        }
        System.out.printf("Total: $%.2f%n",total);


    }
}

package exam;

import java.util.Scanner;

public class TouristShop {
    public static void main (String[]args){
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int counter = 0;
        double price = 0;
        String product = scanner.nextLine();
        while (!product.equals("Stop")) {
            double priceProduct = Double.parseDouble(scanner.nextLine());
            counter++;
            if( counter % 3 == 0){
                priceProduct = priceProduct/2;
            }

            budget -= priceProduct;
            if (budget < 0){
                break;
            }
            price += priceProduct;

            product = scanner.nextLine();
        }

        if (product.equals("Stop")){
            System.out.printf("You bought %d products for %.2f leva.%n",counter,price);
        }else {
            System.out.println("You don't have enough money!");
              System.out.printf("You need %.2f leva!", Math.abs(budget));
        }

    }
}

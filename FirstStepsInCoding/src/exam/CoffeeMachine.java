package exam;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        String drink = scanner.nextLine();
        String sugar =scanner.nextLine();
        int countDrink = Integer.parseInt(scanner.nextLine());

        double price = 0;
        if (drink.equals("Espresso")){
                if (sugar.equals("Without")) {
                    price = 0.90;
                    price = 0.90 * 0.65;
                } else if (sugar.equals("Normal")) {
                    price = 1.00;
                } else if (sugar.equals("Extra")) {
                    price = 1.20;
                }
            if (countDrink > 5) {
                price = price * 0.75;
            }

        }else if (drink.equals("Cappuccino")){
            if (sugar.equals("Without")){
                price = 1.00;
                price = 1.00 * 0.65;
            }else if(sugar.equals("Normal")){
                price = 1.20;
            }else if(sugar.equals("Extra")){
                price = 1.60;
            }

        }else if(drink.equals("Tea")){
            if (sugar.equals("Without")){
                price = 0.50;
                price = 0.50 * 0.65;
            }else if(sugar.equals("Normal")){
                price = 0.60;
            }else if(sugar.equals("Extra")){
                price = 0.70;
            }



        }
        double drinkPrice = countDrink * price;
        if (drinkPrice > 15){
            drinkPrice = drinkPrice * 0.80;
        }
        System.out.printf("You bought %d cups of %s for %.2f lv.", countDrink,drink, drinkPrice);
    }
}

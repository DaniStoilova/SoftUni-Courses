package exam;

import java.util.Scanner;

public class EnergyBooster {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        String fruit = scanner.nextLine();
        String set = scanner.nextLine();
        int countSet = Integer.parseInt(scanner.nextLine());

        double price = 0;

        switch (fruit){
            case "Watermelon":
                if (set.equals("small")){
                    price = 56;
                    price = 2 * price;
                }else if(set.equals("big")){
                    price = 28.70;
                    price = 5 * price;
                }
                break;
            case "Mango":
                if (set.equals("small")){
                    price = 36.66;
                    price = 2 * price;
                }else if(set.equals("big")){
                    price = 19.60;
                    price = 5 * price;
                }
                break;

            case "Pineapple":
                if (set.equals("small")){
                    price = 42.10;
                    price = 2 * price;
                }else if(set.equals("big")){
                    price = 24.80;
                    price = 5 * price;
                }
                break;
            case "Raspberry":
                if (set.equals("small")){
                    price = 20;
                    price = 2 * price;
                }else if(set.equals("big")){
                    price = 15.20;
                    price = 5 * price;
                }
                break;
        }
        double totalPrice = countSet * price;
        if (totalPrice >= 400 && totalPrice <= 1000){
            totalPrice = totalPrice * 0.85;
        }else if (totalPrice > 1000){
            totalPrice = totalPrice * 0.50;
        }
        System.out.printf("%.2f lv.", totalPrice);

    }
}

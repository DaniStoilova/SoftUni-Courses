package exam;

import java.util.Scanner;

public class MobileOperator {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        String date = scanner.nextLine();
        String type = scanner.nextLine();
        String internet = scanner.nextLine();
        int countMont = Integer.parseInt(scanner.nextLine());
        double price = 0;
        if (type.equals("Small")){
            if (date.equals("one")){
                price = 9.98;
            }else if(date.equals("two")){
                price = 8.58;
            }

        }else if(type.equals("Middle")){
            if (date.equals("one")){
                price = 18.99;
            }else if(date.equals("two")){
                price = 17.09;
            }


        }else if(type.equals("Large")){
            if (date.equals("one")){
                price = 25.98;
            }else if(date.equals("two")){
                price = 23.59;
            }


        }else if(type.equals("ExtraLarge")){
            if (date.equals("one")){
                price = 35.99;
            }else if(date.equals("two")){
                price = 31.79;
            }
        }
        if (internet.equals("yes")) {


            if (price <= 10) {
                price = price + 5.50;
            } else if (price <= 30) {
                price = price + 4.35;
            } else if (price > 30) {
                price = price + 3.85;
            }
        }else if (internet.equals("no")){

        }

        if (date.equals("two")){
            price = price * 0.9625;
        }
        double totalPrice = price * countMont;
        System.out.printf("%.2f lv.",totalPrice);

    }
}

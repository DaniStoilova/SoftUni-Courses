package BasicSyntaxConditionalStatementsAndLoops;

import java.util.Locale;
import java.util.Scanner;

public class TheatrePromotion {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        String typeDay = scanner.nextLine().toLowerCase();
        int age = Integer.parseInt(scanner.nextLine());

        int price = 0;
        if(typeDay.equals("weekday")){
            if (age >= 0 && age <=18){
                price = 12;
            }else if (age > 18 && age <= 64){
                price = 18;
            }else if (age > 64 && age <= 122){
                price = 12;
            }

        }else if (typeDay.equals("weekend")){
            if (age >= 0 && age <=18){
                price = 15;
            }else if (age > 18 && age <= 64){
                price = 20;
            }else if (age > 64 && age <= 122){
                price = 15;
            }

        }else if (typeDay.equals("holiday")){
            if (age >= 0 && age <=18){
                price = 5;
            }else if (age > 18 && age <= 64){
                price = 12;
            }else if (age > 64 && age <= 122){
                price = 10;
            }

        }

        if (age > 0){
            System.out.printf("%d$", price);
        }else{
            System.out.println("Error!");
        }

    }

}

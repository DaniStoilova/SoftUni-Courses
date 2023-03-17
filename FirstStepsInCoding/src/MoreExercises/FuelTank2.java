package MoreExercises;

import java.util.Locale;
import java.util.Scanner;

public class FuelTank2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fuel = scanner.nextLine().toLowerCase(Locale.ROOT);
        double countFuel = Double.parseDouble(scanner.nextLine());
        String card = scanner.nextLine();
        //•	Бензин – 2.22 лева за един литър,
        //•	Дизел – 2.33 лева за един литър
        //•	Газ – 0.93 лева за литър
        //намаления за литър гориво: 18 ст. за литър бензин, 12 ст. за литър дизел и 8 ст. за литър газ.
        //Ако шофьора е заредил между 20 и 25 литра включително, той получава 8 процента отстъпка от крайната цена,
        // при повече от 25 литра гориво, той получава 10 процента отстъпка от крайната цена.

        double price = 0.0;

        switch (fuel) {
            case"Gas":
            if (card.equals("Yes"))
                price = 0.93 - 0.08;
            else if (card.equals("No"))
                price = 0.93;
            break;
            case"Gasoline":
            if (card.equals("Yes"))
                price = 2.22 - 0.18;
            else if (card.equals("No"))
                price = 2.22;
            break;
            case"Diesel":
            if (card.equals("Yes"))
                price = 2.33 - 0.12;
            else if (card.equals("No"))
                price = 2.33;
            break;

        }
        double totalPrice = countFuel * price;

        if (countFuel > 20 && countFuel<=25){
            totalPrice = totalPrice * 0.92;
        }else if(countFuel > 25){
            totalPrice = totalPrice * 0.90;
        }
        System.out.printf("%.2f lv.",totalPrice);
    }

    }


package exam;

import java.util.Scanner;

public class EasterGuests {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        //•	Един козунак струва 4лв.
        //•	Едно яйце струва 0.45лв.

        int countGuest = Integer.parseInt(scanner.nextLine());
        int budget = Integer.parseInt(scanner.nextLine());

        double countCake = Math.ceil(countGuest * 1.0/3);
        int eggsNeeded = countGuest * 2;
        double priceCake = countCake * 4;
        double priceEggs = eggsNeeded * 0.45;

        double total = priceCake + priceEggs;
        double diff = Math.abs(budget-total);
        if (budget >= total){
            System.out.printf("Lyubo bought %.0f Easter bread and %d eggs.%nHe has %.2f lv. left.%n",countCake,eggsNeeded,diff);
        }else{
            System.out.printf("Lyubo doesn't have enough money.%nHe needs %.2f lv. more.%n",diff);
        }

    }
}

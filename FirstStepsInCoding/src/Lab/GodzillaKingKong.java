package Lab;

import java.util.Scanner;

public class GodzillaKingKong {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        int people = Integer.parseInt(scanner.nextLine());
        double priceOneSuits = Double.parseDouble(scanner.nextLine());

        double sumDekor = budget * 0.10;
        double sumSuits = people * priceOneSuits;

        if (people > 150){
            sumSuits = sumSuits * 0.90;
        }

        double totalPrice = sumDekor + sumSuits;
        double diff = Math.abs(totalPrice - budget);

        if (totalPrice <= budget){
            System.out.println("Action!");
            System.out.printf("Wingard starts filming with %.2f leva left.", diff);
        }else{
            System.out.println("Not enough money!");
            System.out.printf("Wingard needs %.2f leva more.", diff);


        }

    }
}

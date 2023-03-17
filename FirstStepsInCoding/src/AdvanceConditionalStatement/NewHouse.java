package AdvanceConditionalStatement;

import java.util.Scanner;

public class NewHouse {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String typeFlower = scanner.nextLine();
        int countFlowers= Integer.parseInt(scanner.nextLine());
        int budget = Integer.parseInt(scanner.nextLine());

        double totalPrice = 0;
        switch (typeFlower) {
            case "Roses":
                totalPrice = 5 * countFlowers;
                if (countFlowers > 80) {
                    totalPrice =totalPrice - (totalPrice*0.10);
                }
                break;
            case "Dahlias":
                totalPrice = 3.80 * countFlowers;
                if (countFlowers> 90) {
                    totalPrice = totalPrice - ( totalPrice*0.15);
                }
                break;
            case "Tulips":
                totalPrice =2.80 * countFlowers;
                if (countFlowers > 80) {
                    totalPrice = totalPrice - ( totalPrice*0.15);
                }
                break;
            case "Narcissus":
                totalPrice = 3 * countFlowers;
                if (countFlowers < 120) {
                    totalPrice = totalPrice * 1.15;
                }
                break;
            case "Gladiolus":
                totalPrice = 2.50 * countFlowers;
                if (countFlowers < 80) {
                    totalPrice = totalPrice * 1.20;
                }
                break;


        }


        double diff = Math.abs(totalPrice- budget);
        if (totalPrice <= budget) {
            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.",countFlowers, typeFlower,
                    diff);
        }else{

            System.out.printf("Not enough money, you need %.2f leva more.", diff);

        }

    }
}

package MoreExercises;

import java.util.Scanner;

public class MatchTickets {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        String typeTicket = scanner.nextLine();
        int countPeople = Integer.parseInt(scanner.nextLine());

        double transport = 0;
        if (typeTicket.equals("VIP")) {
            double VIP = 499.99;
            if (countPeople >= 1 && countPeople <= 4) {
                transport = budget * 0.25;
            } else if (countPeople >= 5 && countPeople <= 9) {
                transport = budget * 0.40;
            } else if (countPeople >= 10 && countPeople <= 24) {
                transport = budget * 0.50;
            } else if (countPeople >= 25 && countPeople <= 49) {
                transport = budget * 0.60;
            } else {
                transport = budget * 0.75;
            }
            double diff = transport - VIP * countPeople;

            if (VIP * countPeople < transport) {
                System.out.printf("Yes! You have %.2f leva left.",Math.abs(diff));

            } else {
                System.out.printf("Not enough money! You need %.2f leva.", Math.abs(diff));

            }
        }else if (typeTicket.equals("Normal")) {
            double Normal = 249.99;
            if (countPeople >= 1 && countPeople <= 4) {
                transport =  budget * 0.25;
            } else if (countPeople >= 5 && countPeople <= 9) {

                transport = budget * 0.40;
            } else if (countPeople >= 10 && countPeople <= 24) {
                transport = budget * 0.50;
            } else if (countPeople >= 25 && countPeople <= 49) {
                transport = budget * 0.60;
            } else {
                transport = budget * 0.75;
            }
            double diff2 = transport - Normal * countPeople;

            if ( Normal * countPeople < transport){
                System.out.printf("Yes! You have %.2f leva left.", diff2 );

            }else{
                System.out.printf("Not enough money! You need %.2f leva.", diff2);
            }
        }
    }
}


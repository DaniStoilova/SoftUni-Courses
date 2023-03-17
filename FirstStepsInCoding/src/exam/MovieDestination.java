package exam;

import java.util.Scanner;

public class MovieDestination {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        String destination = scanner.nextLine();
        String season = scanner.nextLine();
        int days = Integer.parseInt(scanner.nextLine());
        double price = 0;
        if (season.equals("Winter")){
            if (destination.equals("Dubai")){
                price = 45000;
                price = price * 0.70;
            }else if (destination.equals("Sofia")){
                price = 17000;
                price = price * 1.25;
            }else if (destination.equals("London")){
                price = 24000;
            }

        }else if (season.equals("Summer")){
            if (destination.equals("Dubai")){
                price = 40000;
                price = price * 0.70;
            }else if (destination.equals("Sofia")){
                price = 12500;
                price = price * 1.25;
            }else if (destination.equals("London")){
                price = 20250;
            }

        }

        double totalPrice = price * days;
        if (totalPrice > budget){
            System.out.printf("The director needs %.2f leva more!", Math.abs(totalPrice - budget));
        }else{
            System.out.printf("The budget for the movie is enough! We have %.2f leva left!", Math.abs(totalPrice - budget));
        }

    }
}

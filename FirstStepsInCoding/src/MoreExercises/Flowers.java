package MoreExercises;

import java.util.Scanner;

public class Flowers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countHrizantems = Integer.parseInt(scanner.nextLine());
        int countRoses = Integer.parseInt(scanner.nextLine());
        int countTulips = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        String day = scanner.nextLine();
        double totalPrice = 0;
        double hrizantemi = 0;
        double tulips = 0;
        double roses = 0;

        if (season.equals("Spring") || season.equals("Summer")) {
            hrizantemi = 2;
            roses = 4.10;
            tulips = 2.50;
        } else if (season.equals("Autumn") || season.equals("Winter")) {
            hrizantemi = 3.75;
            roses = 4.50;
            tulips = 4.15;
        }
        totalPrice = hrizantemi * countHrizantems + tulips * countTulips + roses * countRoses;

        if (countTulips > 7 && season.equals("Spring")) {
            totalPrice = totalPrice * 0.95;
        }
        if (countRoses >= 10 && season.equals("Winter")) {
            totalPrice = totalPrice * 0.90;
        }
        if (countRoses + countHrizantems + countTulips > 20 ){
            totalPrice = totalPrice * 0.8;
        }
        if (day.equals("Y")) {
            totalPrice = totalPrice * 1.15;

        } else if (day.equals("N")) {
            totalPrice = totalPrice;

        }
        double priceOneBuket = totalPrice + 2;

        System.out.printf("%.2f", priceOneBuket);
    }
}





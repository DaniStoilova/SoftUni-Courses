package AdvanceConditionalStatement;

import java.util.Scanner;

public class HotelRoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String month = scanner.nextLine();
        int overnight = Integer.parseInt(scanner.nextLine());


        double priceStudio = 0;
        double priceApartment = 0;

        if (month.equals("May") || month.equals("October")) {
            priceStudio = 50;
            priceApartment = 65;
            if (overnight > 7 && overnight <= 14) {
                priceStudio = priceStudio * 0.95;
            } else if (overnight > 14) {
                priceStudio = priceStudio * 0.70;
                priceApartment = priceApartment * 0.90;
            }

        } else if (month.equals("June") || month.equals("September")) {
            priceStudio = 75.20;
            priceApartment = 68.70;
            if (overnight > 14) {
                priceStudio = priceStudio * 0.80;
                priceApartment = priceApartment * 0.90;
            }
        } else {
            priceStudio = 76;
            priceApartment = 77;
            if (overnight > 14) {
                priceApartment = priceApartment * 0.90;
            }
        }

        System.out.printf("Apartment: %.2f lv.%n", priceApartment * overnight);
        System.out.printf("Studio: %.2f lv.", priceStudio * overnight);
    }
}

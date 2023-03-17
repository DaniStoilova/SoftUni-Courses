package Exam1;

import java.util.Scanner;

public class CourierExpress {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        double shipmentKg = Double.parseDouble(scanner.nextLine());
        String type = scanner.nextLine();
        int distanceKm = Integer.parseInt(scanner.nextLine());

        double price = 0;
        double total = 0;
        double total1 = 0;
        if (type.equals("standard")) {
            if (shipmentKg < 1) {
                price = 0.03;
            } else if (shipmentKg >= 1 && shipmentKg < 10) {
                price = 0.05;
            } else if (shipmentKg >= 10 && shipmentKg < 40) {
                price = 0.10;
            } else if (shipmentKg >= 40 && shipmentKg < 90) {
                price = 0.15;
            } else if (shipmentKg >= 90 && shipmentKg < 150) {
                price = 0.20;
            }
            total = distanceKm * price;

        } else if (type.equals("express")) {
            if (shipmentKg < 1) {
                total = distanceKm * 0.03;
                price = (0.03 * 0.8) * shipmentKg;
                total1 = distanceKm * price;
            } else if (shipmentKg >= 1 && shipmentKg < 10) {
                total = distanceKm * 0.05;
                price = (0.05 * 0.40) * shipmentKg;
                total1 = distanceKm * price;
            } else if (shipmentKg >= 10 && shipmentKg < 40) {
                total = distanceKm * 0.10;
                price = (0.10 * 0.05) * shipmentKg;
                total1 = distanceKm * price;
            } else if (shipmentKg >= 40 && shipmentKg < 90) {
                total = distanceKm * 0.15;
                price = (0.15 * 0.02) * shipmentKg;
                total1 = distanceKm * price;

            } else if (shipmentKg >= 90 && shipmentKg < 150) {
                total = distanceKm * 0.20;
                price = (0.20 * 0.01) * shipmentKg;
                total1 = distanceKm * price;

            }

        }

        double sum = total + total1;

        System.out.printf("The delivery of your shipment with weight of %.3f kg. would cost %.2f lv.", shipmentKg, sum);


    }
}

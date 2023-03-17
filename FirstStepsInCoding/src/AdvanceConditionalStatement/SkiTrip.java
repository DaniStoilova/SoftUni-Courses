package AdvanceConditionalStatement;

import java.util.Scanner;

public class SkiTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        String room = scanner.nextLine();
        String grade = scanner.nextLine();
        double price = 0;
        double totalPrice = 0;
        if (room.equals("room for one person")) {
            if (days < 10) {
                price = 18;
            } else if (days > 10 && days < 15) {
                price = 18;
            } else {
                price = 18;
            }
            if (grade.equals("positive")) {
                totalPrice = (price + (price * 0.25)) * (days - 1);

            } else if (grade.equals("negative")) {
                totalPrice = (price - (price * 0.10)) * (days - 1);
            }

        } else if (room.equals("apartment")) {
            price = 25;
            if (days < 10) {
                price = price * 0.70;
            } else if (days > 10 && days < 15) {
                price = price * 0.65;
            } else {
                price = price * 0.50;
            }
            if (grade.equals("positive")) {
                totalPrice = (price + (price * 0.25)) * (days - 1);

            } else if (grade.equals("negative")) {
                totalPrice = (price - (price * 0.10)) * (days - 1);

            }

        } else if (room.equals("president apartment")) {
            price = 35;
            if (days < 10) {
                price = price * 0.90;
            } else if (days > 10 && days < 15) {
                price = price * 0.85;
            } else {
                price = price * 0.80;
            }
            if (grade.equals("positive")) {
                totalPrice = (price + (price * 0.25)) * (days - 1);

            } else if (grade.equals("negative")) {
                totalPrice = (price - (price * 0.10)) * (days - 1);

            }
        }
        System.out.printf("%.2f", totalPrice);
    }
}

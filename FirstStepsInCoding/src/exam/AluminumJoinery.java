package exam;

import java.util.Scanner;

public class AluminumJoinery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countAluminum = Integer.parseInt(scanner.nextLine());
        String typeAluminum = scanner.nextLine();
        String delivery = scanner.nextLine();

        boolean isFound = false;
        double price = 0;
        if (typeAluminum.equals("90X130")) {
            price = 110;
            price = countAluminum * price;
            if (countAluminum >= 30 && countAluminum <= 60) {
                price = price * 0.95;

            } else if (countAluminum > 60) {
                price = price * 0.92;
            }
            if (delivery.equals("With delivery")) {
                price = price + 60;
            } else if (delivery.equals("Without delivery")) {

            }
        } else if (typeAluminum.equals("100X150")) {
            price = 140;
            price = countAluminum * price;
            if (countAluminum >= 40 && countAluminum <= 80) {
                price = price * 0.94;
            } else if (countAluminum > 80) {
                price = price * 0.90;
            }
            if (delivery.equals("With delivery")) {
                price = price + 60;
            } else if (delivery.equals("Without delivery")) {

            }

        } else if (typeAluminum.equals("130X180")) {
            price = 190;
            price = countAluminum * price;
            if (countAluminum >= 20 && countAluminum <= 50) {
                price = price * 0.93;
            } else if (countAluminum > 50) {
                price = price * 0.88;
            }
            if (delivery.equals("With delivery")) {
                price = price + 60;
            } else if (delivery.equals("Without delivery")) {

            }
        } else if (typeAluminum.equals("200X300")) {
            price = 250;
            price = countAluminum * price;
            if (countAluminum >= 25 && countAluminum <= 50) {
                price = price * 0.91;
            } else if (countAluminum > 50) {
                price = price * 0.86;
            }
            if (delivery.equals("With delivery")) {
                price = price + 60;
            } else if (delivery.equals("Without delivery")) {

            }
        }
        if (countAluminum > 99) {
            price = price * 0.96;
        }
        if (countAluminum < 10) {
            isFound = true;

        }
        if (isFound) {
            System.out.println("Invalid order");
        } else {
            System.out.printf("%.2f BGN", price);
        }
    }
}

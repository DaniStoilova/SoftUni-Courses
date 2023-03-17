package exam;

import java.util.Scanner;

public class VetParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countDays = Integer.parseInt(scanner.nextLine());
        int countHours = Integer.parseInt(scanner.nextLine());

        double total = 0;
        double price = 0;

        for (int i = 1; i <= countDays; i++) {
            double days = 0;
            for (int j = 1; j <= countHours; j++) {

                if (i % 2 == 0 && j % 2 != 0) {
                    price = 2.50;
                } else if (i % 2 != 0 && j % 2 == 0) {
                    price = 1.25;
                } else {
                    price = 1;
                }
                days += price;

            }
            total += days;
            System.out.printf("Day: %d - %.2f leva%n", i, days);
        }

        System.out.printf("Total: %.2f leva%n", total);

    }
}

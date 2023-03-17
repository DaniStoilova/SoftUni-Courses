package exam;

import java.util.Scanner;

public class GrantmaStavri {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());

        double total = 0;
        double total1 = 0;

        double sum = 0;
        for (int i = 1; i <= days; i++) {
            double quantity = Double.parseDouble(scanner.nextLine());
            total += quantity;

            double degrees = Double.parseDouble(scanner.nextLine());

            total1 = quantity * degrees;


            sum += total1;
        }
        double diff = sum / total;
        System.out.printf("Liter: %.2f%n", total);
        System.out.printf("Degrees: %.2f%n", diff);
        if (diff < 38) {
            System.out.println("Not good, you should baking");
        } else if (diff >= 38 && diff <= 42) {
            System.out.println("Super!");
        } else if (diff > 42) {
            System.out.println("Dilution with distilled water!");

        }
    }
}


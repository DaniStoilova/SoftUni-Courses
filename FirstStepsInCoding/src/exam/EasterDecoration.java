package exam;

import java.util.Scanner;

public class EasterDecoration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countCustomer = Integer.parseInt(scanner.nextLine());
        double sum = 0;
        for (int i = 1; i <= countCustomer; i++) {
            double price = 0;
            double total = 0;
            int counter = 0;
            String input = scanner.nextLine();
            while (!input.equals("Finish")) {
                String sale = input;

                if (sale.equals("basket")) {
                    price = 1.50;
                } else if (sale.equals("wreath")) {
                    price = 3.80;
                } else if (sale.equals("chocolate bunny")) {
                    price = 7.00;
                }
                counter++;
                total += price;

                input = scanner.nextLine();
            }

            if (counter % 2 ==0)
                total = total*0.80;
            sum += total;
            if (input.equals("Finish")){
                System.out.printf("You purchased %d items for %.2f leva.%n",counter,total);
            }

        }
        System.out.printf("Average bill per client is: %.2f leva.", sum/countCustomer);

    }
}

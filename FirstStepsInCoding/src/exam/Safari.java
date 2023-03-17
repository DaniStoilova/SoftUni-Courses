package exam;

import java.util.Scanner;

public class Safari {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        double litreFuel = Double.parseDouble(scanner.nextLine());
        String dayOfWeek = scanner.nextLine();


        double fuels = litreFuel * 2.10;
        double totalPrice = fuels + 100;

        if (dayOfWeek.equals("Saturday")) {
            totalPrice = totalPrice * 0.90;

        } else if (dayOfWeek.equals("Sunday")) {
            totalPrice = totalPrice * 0.80;
        }
        double diff = Math.abs(budget - totalPrice);
        if (budget >= totalPrice) {
            System.out.printf("Safari time! Money left: %.2f lv.", diff);
        }else{
            System.out.printf("Not enough money! Money needed: %.2f lv.",diff);
        }

    }
}

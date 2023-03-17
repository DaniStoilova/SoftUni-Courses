package exam;

import java.util.Scanner;

public class EasterParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countGuest = Integer.parseInt(scanner.nextLine());
        double priceOnePerson = Double.parseDouble(scanner.nextLine());
        double budget = Double.parseDouble(scanner.nextLine());


        if (countGuest >= 10 && countGuest <= 15) {
            priceOnePerson = priceOnePerson * 0.85;
        } else if (countGuest >15 && countGuest <= 20) {
            priceOnePerson = priceOnePerson * 0.80;
        } else if (countGuest > 20) {
            priceOnePerson = priceOnePerson * 0.75;
        }
        double priceCake = budget * 0.10;

        double total = countGuest * priceOnePerson + priceCake;

        if (budget > total){
            System.out.printf("It is party time! %.2f leva left.",Math.abs(total - budget));
        }else{
            System.out.printf("No party! %.2f leva needed.", Math.abs(budget-total));
        }

    }
}

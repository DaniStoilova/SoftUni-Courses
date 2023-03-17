package exam;

import java.util.Scanner;

public class AgencyProfit {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int ticketAdult = Integer.parseInt(scanner.nextLine());
        int ticketChild = Integer.parseInt(scanner.nextLine());
        double priceAdult = Double.parseDouble(scanner.nextLine());
        double tax =Double.parseDouble(scanner.nextLine());

        double priceChild = priceAdult * 0.30;
        double priceTaxAdult = priceAdult + tax;
        double priceTaxChild = priceChild + tax;

        double totalTickets = (ticketChild * priceTaxChild) + (ticketAdult * priceTaxAdult);
        double profit = (0.20 * totalTickets);

        System.out.printf("The profit of your agency from %s tickets is %.2f lv.", name, profit);

    }
}

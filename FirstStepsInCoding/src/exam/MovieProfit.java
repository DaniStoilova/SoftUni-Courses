package exam;

import java.util.Scanner;

public class MovieProfit {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        String movie = scanner.nextLine();
        int countDays = Integer.parseInt(scanner.nextLine());
        int countTickets = Integer.parseInt(scanner.nextLine());
        double priceTicket = Double.parseDouble(scanner.nextLine());
        int percent = Integer.parseInt(scanner.nextLine());

        double ticketPriceOneDay = countTickets * priceTicket;
        double totalPrice = ticketPriceOneDay * countDays;
        double percentCinema = totalPrice * percent/100;

        double profit = totalPrice - percentCinema;

        System.out.printf("The profit from the movie %s is %.2f lv.",movie,profit);


    }
}

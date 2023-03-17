package exam;

import java.util.Scanner;

public class TennisEquipment {
    public static void main (String[]args){
        Scanner scanner = new Scanner(System.in);

        double priceTennis = Double.parseDouble(scanner.nextLine());
        int countTennis = Integer.parseInt(scanner.nextLine());
        int countShoes = Integer.parseInt(scanner.nextLine());

        double totalPrice = priceTennis * countTennis;
        double priceShoes = priceTennis/6;
        double priceAllShoes =  countShoes * priceShoes;
        double price = (totalPrice + priceAllShoes)*0.2;
        double total = totalPrice + priceAllShoes + price;

        double priceDjokovic = Math.floor(total/8);
        double priceSponsors = Math.ceil(total*7/8);
        System.out.printf("Price to be paid by Djokovic %.0f%n",priceDjokovic);
        System.out.printf("Price to be paid by sponsors %.0f",priceSponsors);
    }
}

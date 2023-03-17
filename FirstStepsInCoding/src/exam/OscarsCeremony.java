package exam;

import java.util.Scanner;

public class OscarsCeremony {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        int rent = Integer.parseInt(scanner.nextLine());

        double priceFigurine = rent * 0.70;
        double priceCatering = priceFigurine * 0.85;
        double priceMusic = priceCatering/2;

        double totalPrice = rent + priceFigurine + priceCatering + priceMusic;

        System.out.printf("%.2f",totalPrice);


    }
}

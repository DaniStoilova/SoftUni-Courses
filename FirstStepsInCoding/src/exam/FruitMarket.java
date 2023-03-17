package exam;

import java.util.Scanner;

public class FruitMarket {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        double priceStrawberry = Double.parseDouble(scanner.nextLine());
        double countBananaKg = Double.parseDouble(scanner.nextLine());
        double countOrangeKg = Double.parseDouble(scanner.nextLine());
        double countRaspberryKg = Double.parseDouble(scanner.nextLine());
        double countStrawberryKg = Double.parseDouble(scanner.nextLine());

        double priceRaspberry = priceStrawberry/2;
        double priceOrange = priceRaspberry * 0.60;
        double priceBanana = priceRaspberry * 0.20;

        double sumRaspberry = priceRaspberry * countRaspberryKg;
        double sumOrange = priceOrange * countOrangeKg;
        double sumBanana = priceBanana * countBananaKg;
        double sumStrawberry = priceStrawberry * countStrawberryKg;

        double totalSum = sumRaspberry + sumOrange + sumBanana + sumStrawberry;

        System.out.printf("%.2f", totalSum);


    }
}

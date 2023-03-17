package exam;

import java.util.Scanner;

public class EasterBakery {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        double flour = Double.parseDouble(scanner.nextLine());
        double kgFlour = Double.parseDouble(scanner.nextLine());
        double kgSugar = Double.parseDouble(scanner.nextLine());
        int eggs = Integer.parseInt(scanner.nextLine());
        int may = Integer.parseInt(scanner.nextLine());

        double priceSugar = flour * 0.75;
        double priceEggs = flour * 1.10;
        double priceMay = priceSugar * 0.20;

        double sumFlour = flour * kgFlour;
        double sumSugar = priceSugar * kgSugar;
        double sumEggs = priceEggs * eggs;
        double sumMay = priceMay * may;

        double total = sumFlour + sumSugar + sumEggs + sumMay;

        System.out.printf("%.2f",total);


    }
}

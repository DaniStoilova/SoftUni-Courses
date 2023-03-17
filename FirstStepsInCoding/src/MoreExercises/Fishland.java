package MoreExercises;

import java.util.Scanner;

public class Fishland {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        double priceMackerelKg = Double.parseDouble(scanner.nextLine());
        double priceToyKg = Double.parseDouble(scanner.nextLine());
        double bonitoKg = Double.parseDouble(scanner.nextLine());
        double horseMackerelKg = Double.parseDouble(scanner.nextLine());
        int musselsKg = Integer.parseInt(scanner.nextLine());

        double priceBonitoKg = priceMackerelKg + priceMackerelKg * 0.60;
        double priceHorseMackerelsKg = priceToyKg + priceToyKg * 0.80;

        double priceBonito = bonitoKg * priceBonitoKg;
        double priceHorseMackerels = horseMackerelKg * priceHorseMackerelsKg;
        double priseMussels = musselsKg * 7.50;
        double totalSum = priceBonito + priceHorseMackerels+ priseMussels;

        System.out.printf("%.2f", totalSum);

    }
}

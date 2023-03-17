package MoreExercises;

import java.util.Scanner;

public class VegetableMarket {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        double priceKgVegetables = Double.parseDouble(scanner.nextLine());
        double priceKgFruits = Double.parseDouble(scanner.nextLine());
        int allKgVegetables = Integer.parseInt(scanner.nextLine());
        int allKgFruits = Integer.parseInt(scanner.nextLine());

        // 1 euro = 1.94 ;

        double totalVegetables = priceKgVegetables * allKgVegetables;
        double totalFruits = priceKgFruits * allKgFruits;

        double totalSum = totalVegetables + totalFruits;

        double totalPriceEuro = totalSum/1.94;

        System.out.printf("%.2f",totalPriceEuro);




    }
}

package MoreExercises;

import java.util.Scanner;

public class CarToGo {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();

        String cl = "";
        String car = "";
        double price = 0;
        if (budget <= 100){
            cl = "Economy class";
            if (season.equals("Summer")){
                car = "Cabrio";
                price= budget * 0.35;
            }else if(season.equals("Winter")){
                car = "Jeep";
                price = budget * 0.65;
            }

        } else if (budget > 100 && budget <= 500) {
            cl = "Compact class";
            if (season.equals("Summer")){
                car = "Cabrio";
                price= budget * 0.45;
            }else if(season.equals("Winter")){
                car = "Jeep";
                price = budget * 0.80;
            }
        }else if (budget > 500){
            cl = "Luxury class";
            car = "Jeep";
            price = budget * 0.90;


        }

        System.out.println(cl);
        System.out.printf("%s - %.2f", car, price);
    }
}

package MoreExercises;

import java.util.Scanner;

public class TruckDriver {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String season = scanner.nextLine();
        double kmMount = Double.parseDouble(scanner.nextLine());


        double price = 0;
        if (season.equals("Spring") || season.equals("Autumn")){
            if (kmMount <= 5000){
                price = 0.75;

            }else if (kmMount > 5000 && kmMount <= 10000){
                price = 0.95;

            }else if (kmMount > 10000 && kmMount <= 20000){
                price = 1.45;

            }


        }else if (season.equals("Summer")){
            if (kmMount <= 5000){
                price = 0.90;

            }else if (kmMount > 5000 && kmMount <= 10000){
                price = 1.10;

            }else if (kmMount > 10000 && kmMount <= 20000){
                price = 1.45;

            }


        }else if (season.equals("Winter")){
            if (kmMount <= 5000){
                price = 1.05;

            }else if (kmMount > 5000 && kmMount <= 10000){
                price = 1.25;

            }else if (kmMount > 10000 && kmMount <= 20000){
                price = 1.45;

            }


        }

        double salary = (kmMount * price) * 4 * 0.90;
        System.out.printf("%.2f", salary);


    }
}


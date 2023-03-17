package MoreExercises;

import java.util.Scanner;

public class TransportPrice {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String dayOrNight = scanner.nextLine();

        double price = 0.0;
        if (n < 20){
           if(dayOrNight.equals("day")) {
               price = 0.70 + n * 0.79;
           }if (dayOrNight.equals("night")) {
                price = 0.70 + n * 0.90;
            }
        }else if (n < 100){
            price = n * 0.09;

        }else{
            price = n * 0.06;
        }
        System.out.printf("%.2f",price);

    }
}

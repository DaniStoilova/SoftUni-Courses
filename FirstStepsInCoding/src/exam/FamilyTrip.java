package exam;

import java.util.Scanner;

public class FamilyTrip {
    public static  void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        int countNight = Integer.parseInt(scanner.nextLine());
        double priceNight = Double.parseDouble(scanner.nextLine());
        int percent = Integer.parseInt(scanner.nextLine());


        if (countNight > 7){
            priceNight = priceNight * 0.95;
        }
        double totalSum = priceNight * countNight;
        double totalrazhod = budget * percent/100;

        double total = totalSum + totalrazhod;

        double diff = Math.abs(total - budget);
        if (total <= budget){
            System.out.printf("Ivanovi will be left with %.2f leva after vacation.", diff);
        }else {
            System.out.printf("%.2f leva needed.", diff);
        }


    }
}

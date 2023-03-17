package MoreExercises;

import java.util.Scanner;

public class BikeRace {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int juniorsBiker = Integer.parseInt(scanner.nextLine());
        int seniorsBiker = Integer.parseInt(scanner.nextLine());
        String trace = scanner.nextLine();

        double juniors = 0;
        double seniors = 0;

        if (trace.equals("trail")){
            juniors = 5.50;
            seniors = 7;
        }else if (trace.equals("cross-country")){
            juniors = 8;
            seniors = 9.50;
        }else if (trace.equals("downhill")){
            juniors = 12.25;
            seniors = 13.75;
        }else if (trace.equals("road")){
            juniors = 20;
            seniors = 21.50;
        }
        double tax = juniorsBiker*juniors + seniorsBiker*seniors;
        double bikers = juniorsBiker+seniorsBiker;

        if (bikers >= 50){
            tax = (tax*0.75)*0.95;
            System.out.printf("%.2f",tax);

        }else{
            tax = tax*0.95;
            System.out.printf("%.2f", tax);
        }
    }
}

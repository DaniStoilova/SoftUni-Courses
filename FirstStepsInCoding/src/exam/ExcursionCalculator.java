package exam;

import java.util.Scanner;

public class ExcursionCalculator {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        int countPeople = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();

        double price=0;
        if (season.equals("spring")){
            if(countPeople <=5){
            price = 50.00;
            }else if(countPeople > 5){
                price = 48.00;
            }

        }else if(season.equals("summer")){
            if(countPeople <=5){
                price = 48.50;
            }else if(countPeople > 5){
                price = 45.00;
            }


        }else if(season.equals("autumn")){
            if(countPeople <=5){
                price = 60.00;
            }else if(countPeople > 5){
                price = 49.50;
            }

        }else if(season.equals("winter")){
            if(countPeople <=5){
                price = 86.00;
            }else if(countPeople > 5){
                price = 85.00;
            }

        }

        double total = countPeople * price;
        if(season.equals("summer")){
            total = total*0.85;
        }else if (season.equals("winter")){
            total = total*1.08;
        }

        System.out.printf("%.2f leva.", total);

    }
}

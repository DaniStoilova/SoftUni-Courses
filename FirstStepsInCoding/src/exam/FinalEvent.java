package exam;

import java.util.Scanner;

public class FinalEvent {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        int countDancer = Integer.parseInt(scanner.nextLine());
        double points = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();
        String place = scanner.nextLine();

        double price = 0;
        double total =0;
        double charity = 0;
        if (place.equals("Bulgaria")){
            if(season.equals("summer")){
                price = countDancer * points;
                price = price * 0.95;
            }else if(season.equals("winter")){
                price = countDancer * points;
                price = price * 0.92;
            }


        }else if (place.equals("Abroad")){
            if(season.equals("summer")){
                price = (countDancer * points)*1.5;
                price = price * 0.90;
            }else if(season.equals("winter")){
                price = (countDancer * points)*1.5;
                price = price * 0.85;
            }


        }
        total = price * 0.75;
        charity = price - total;

        System.out.printf("Charity - %.2f%n",total);
        System.out.printf("Money per dancer - %.2f",charity/countDancer);


    }
}

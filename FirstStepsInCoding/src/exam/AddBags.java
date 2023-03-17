package exam;

import java.util.Scanner;

public class AddBags {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        double priceLuggageUp20 = Double.parseDouble(scanner.nextLine());
        double kgLuggage = Double.parseDouble(scanner.nextLine());
        int days = Integer.parseInt(scanner.nextLine());
        int countLuggage = Integer.parseInt(scanner.nextLine());

        double taxLuggage = 0.0;
        if (kgLuggage < 10){
            taxLuggage = (0.2 * priceLuggageUp20);
        }else if (kgLuggage <= 20){
            taxLuggage = (0.50 * priceLuggageUp20);
        }else{
            taxLuggage = priceLuggageUp20;
        }
        if (days < 7){
            taxLuggage = taxLuggage +(taxLuggage * 0.40);
        }else if (days <= 30) {
            taxLuggage = taxLuggage +(taxLuggage * 0.15);
        }else{
            taxLuggage = taxLuggage +(taxLuggage * 0.10);
        }

        double totalSum = taxLuggage * countLuggage;

        System.out.printf("The total price of bags is: %.2f lv.", totalSum);



    }
}

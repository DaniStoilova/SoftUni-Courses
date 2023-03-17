package exam;

import java.util.Scanner;

public class Club {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        double profit = Double.parseDouble(scanner.nextLine());
        String cocktail = scanner.nextLine();

        double income = 0.0;

        while (!cocktail.equals("Party!")){
            int countCocktails = Integer.parseInt(scanner.nextLine());
            int price = countCocktails * cocktail.length();
            double finalPrice = price;
            if (price % 2 != 0){
                finalPrice = price * 0.75;
            }
            income += finalPrice;
            profit -= finalPrice;
            if (profit <= 0){
                break;
            }
            cocktail = scanner.nextLine();
        }
        if (cocktail.equals("Party!")){
            System.out.printf("We need %.2f leva more.%n",profit);
            System.out.printf("Club income - %.2f leva.", income);
        }else{
            System.out.printf("Target acquired.%n");
            System.out.printf("Club income - %.2f leva.", income);
        }
    }
}

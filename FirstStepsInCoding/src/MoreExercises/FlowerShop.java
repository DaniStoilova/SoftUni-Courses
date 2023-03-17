package MoreExercises;

import java.util.Scanner;

public class FlowerShop {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int countM = Integer.parseInt(scanner.nextLine());
        int countZ= Integer.parseInt(scanner.nextLine());
        int countRoses= Integer.parseInt(scanner.nextLine());
        int countCactus = Integer.parseInt(scanner.nextLine());
        double pricePresent= Double.parseDouble(scanner.nextLine());
        // Магнолии – 3.25 лева
        // Зюмбюли – 4 лева
        // Рози – 3.50 лева
        // Кактуси – 8 лева
        //От общата сума, Мария трябва да плати 5% данъци.
        double totalSum = countM * 3.25 + countZ * 4 + countRoses * 3.50 + countCactus * 8;
        double tax = totalSum * 0.95;
        double result =Math.abs(pricePresent - tax);
        if (tax >= pricePresent){
            System.out.printf("She is left with %.0f leva.", Math.floor(result));
        }else{
            System.out.printf("She will have to borrow %.0f leva.", Math.ceil(result));
        }
    }
}

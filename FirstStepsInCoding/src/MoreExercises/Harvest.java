package MoreExercises;

import java.util.Scanner;

public class Harvest {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int x = Integer.parseInt(scanner.nextLine());
        double y = Double.parseDouble(scanner.nextLine());
        int z = Integer.parseInt(scanner.nextLine());
        int countWorkers = Integer.parseInt(scanner.nextLine());

        double totalGrapes = x * y;
        double wine = 0.40*totalGrapes/2.5;
        double totalVine = Math.floor(Math.abs(z - wine));
        double vineOneWorkers =Math.ceil(totalVine/countWorkers);

        if (wine < z){ // 208 < 175
            System.out.printf("It will be a tough winter! More %.0f liters wine needed.", totalVine);
        }else{
            System.out.printf("Good harvest this year! Total wine: %.0f liters.%n",wine);
            System.out.printf("%.0f liters left -> %.0f liters per person.",totalVine,vineOneWorkers);
        }

    }
}


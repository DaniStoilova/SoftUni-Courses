package exam;

import java.util.Scanner;

public class CatDiet {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        //•	1 грам мазнини = 9 калории
        //•	1 грам протеини = 4 калории
        //•	1 грам въглехидрати = 4 калории

        int fat = Integer.parseInt(scanner.nextLine());
        int proteinPercent = Integer.parseInt(scanner.nextLine());
        int carbohydratePercent = Integer.parseInt(scanner.nextLine());
        int calories = Integer.parseInt(scanner.nextLine());
        int water = Integer.parseInt(scanner.nextLine());

        double totalFat = (calories*1.0/100 * fat)/9;
        double totalProtein = (calories*1.0/100 * proteinPercent)/4;
        double totalCarbohydrate = (calories * 1.0/100 * carbohydratePercent)/4;

        double total = totalFat + totalProtein + totalCarbohydrate;

        double caloriesOneGr = calories/total;

        double withoutWater = caloriesOneGr*(100 - water)/100;

        System.out.printf("%.4f", withoutWater);

    }
}

package MoreExercises;

import java.util.Scanner;

public class Bills {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int mountAverage = Integer.parseInt(scanner.nextLine());



        double totalEl = 0;
        for (int i=1; i <= mountAverage; i++){
            double taxEl= Double.parseDouble(scanner.nextLine());
            totalEl += taxEl;

        }
        double water = 20 * mountAverage;
        double internet = 15 * mountAverage;
        double totalSum = (totalEl + water + internet);
        double others = (totalSum * 0.2) + totalSum;
        double averageSum = (others + totalSum)/mountAverage;


        System.out.printf("Electricity: %.2f lv%n", totalEl);
        System.out.printf("Water: %.2f lv%n", water);
        System.out.printf("Internet: %.2f lv%n", internet);
        System.out.printf("Other: %.2f lv%n", others);
        System.out.printf("Average: %.2f lv%n", averageSum);

    }
}

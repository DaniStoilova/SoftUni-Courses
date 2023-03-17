package Exam1;

import java.util.Scanner;

public class P06 {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());


        for (int i = 1; i <= n; i++){
            double gold = Double.parseDouble(scanner.nextLine());
            int days = Integer.parseInt(scanner.nextLine());
            int average = 0;
            for (int j = 1; j <= days; j++) {
            double goldDays = Double.parseDouble(scanner.nextLine());

            average += goldDays;


            }
            double averageGold = average * 1.0/days;
            if (averageGold >= gold){
                System.out.printf("Good job! Average gold per day: %.2f.%n",averageGold);
            }else{
                System.out.printf("You need %.2f gold.%n", Math.abs(averageGold-gold));
            }
        }
    }
}

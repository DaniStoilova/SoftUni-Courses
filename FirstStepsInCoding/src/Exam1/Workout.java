package Exam1;

import java.util.Scanner;

public class Workout {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = Integer.parseInt(scanner.nextLine());
        double m = Double.parseDouble(scanner.nextLine());
        double total = 0;
        double sum = m;
        int norm = 1000;
        for (int i = 1; i <= days; i++) {
            int percent = Integer.parseInt(scanner.nextLine());

            sum += sum * percent * 1.0 / 100;

            total += sum;

        }
        double totalSum =Math.floor(total + m);
        double diff =  Math.abs(totalSum - 1000);
        if (totalSum >= norm){
            System.out.printf("You've done a great job running %.0f more kilometers!", totalSum);
        }else {
            System.out.printf("Sorry Mrs. Ivanova, you need to run %.0f more kilometers",diff);
        }
    }
}
package DataTypesAndVariablesExercise;

import java.util.Scanner;

public class SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sourse = Integer.parseInt(scanner.nextLine());


        int days = 0;
        int totalSumSpice = 0;
        while (sourse >= 100){
            int spice = sourse - 26;
            totalSumSpice += spice;
            days++;
            sourse -= 10;


        }
        System.out.println(days);
        if(totalSumSpice >= 26){
            totalSumSpice -= 26;
        }
        System.out.println(totalSumSpice);


    }
}

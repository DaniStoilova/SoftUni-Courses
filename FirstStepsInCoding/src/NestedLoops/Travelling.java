package NestedLoops;

import java.util.Scanner;

public class Travelling {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String destination = scanner.nextLine();
        while (!destination.equals("End")){
            double moneyNeeded = Double.parseDouble(scanner.nextLine());

            double sum = 0;
            while (sum < moneyNeeded){
                double currentMoney = Double.parseDouble(scanner.nextLine());
                sum += currentMoney;
            }

            System.out.printf("Going to %s!%n",destination);

            destination = scanner.nextLine();

        }
    }
}

package WhileLoopExam;

import java.util.Scanner;

public class ReportSystem {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int sum = Integer.parseInt(scanner.nextLine());

        int totalSum = 0;
        int cash =0;
        int pos = 0;
        int countDays = 0;
        int countCash = 0;
        int countPos = 0;

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            int price = Integer.parseInt(input);
            countDays++;
            if (countDays % 2 == 0) {
                if (price <= 10) {
                    System.out.println("Error in transaction!");
                } else if (price > 10) {
                    System.out.println("Product sold!");
                    totalSum += price;
                    pos += price;
                    countPos++;
                }
            } else {
                if (price <= 100) {
                    System.out.println("Product sold!");
                    totalSum += price;
                    cash += price;
                    countCash++;
                } else if(price > 100) {
                    System.out.println("Error in transaction!");
                }

                if (totalSum >= sum) {
                    System.out.printf("Average CS: %.2f%n", cash * 1.0 / countCash);
                    System.out.printf("Average CS: %.2f%n", pos * 1.0 / countPos);
                    break;
                }
                input = scanner.nextLine();
            }

        }
        if (input.equals("End")){
               System.out.println("Failed to collect required money for charity.");
            }

    }

}

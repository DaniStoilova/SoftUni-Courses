package exam;

import java.util.Scanner;

public class SuitcasesLoad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double trunk = Double.parseDouble(scanner.nextLine());

        String input = scanner.nextLine();
        int luggage = 0;
        while (!input.equals("End")) {
            double volumeLuggage = Double.parseDouble(input);
            if (volumeLuggage >= trunk) {
                break;
            }
            luggage++;
            if (luggage % 3 == 0) {
                volumeLuggage = volumeLuggage * 1.10;
            }

            trunk -= volumeLuggage;
            input = scanner.nextLine();
        }

        if (input.equals("End")) {
            System.out.println("Congratulations! All suitcases are loaded!");
            System.out.printf("Statistic: %d suitcases loaded.", luggage);
        }else{
            System.out.println("No more space!");
            System.out.printf("Statistic: %d suitcases loaded.", luggage);
        }
    }
}

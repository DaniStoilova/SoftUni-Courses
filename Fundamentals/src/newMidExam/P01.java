package newMidExam;

import java.util.Scanner;

public class P01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double size = Double.parseDouble(scanner.nextLine());

        int numPaper = Integer.parseInt(scanner.nextLine());

        double sizeGiftBox = size * size * 6;
        double area = 0.0;
        double sum = 0.0;
        double totalArea = 0.0;
        for (int i = 1; i <= numPaper; i++) {
            double length = Double.parseDouble(scanner.nextLine());
            double width = Double.parseDouble(scanner.nextLine());

            area = length * width;

            if (i % 3 == 0) {


                area = area * 0.75;
            }
            if (i % 5 == 0) {
                continue;

            }


            sum += area;


        }


        if (sizeGiftBox > sum) {
            totalArea = (sizeGiftBox - sum) / sizeGiftBox * 100;
            System.out.println("You are out of paper!");
            System.out.printf("%.2f%% of the box is not covered.%n", totalArea);
        } else {
            totalArea = (sum - sizeGiftBox) / sum * 100;
            System.out.println("You've covered the gift box!");
            System.out.printf("%.2f%% wrap paper left.%n", totalArea);
        }


    }
}

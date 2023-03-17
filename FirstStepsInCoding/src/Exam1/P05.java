package Exam1;

import java.util.Scanner;

public class P05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int adult = 0;
        int child = 0;
        int toys = 0;
        int pullover = 0;
        String input = scanner.nextLine();
        while (!input.equals("Christmas")) {
            int age = Integer.parseInt(input);

            if (age <= 16) {
                child++;
                toys++;
            } else if (age > 16) {
                adult++;
                pullover++;
            }

            input = scanner.nextLine();
        }

        int allToys = toys * 5;
        int allPullovers = pullover * 15;
        if (input.equals("Christmas")) {
            System.out.printf("Number of adults: %d%n", adult);
            System.out.printf("Number of kids: %d%n", child);
            System.out.printf("Money for toys: %d%n", allToys );
            System.out.printf("Money for sweaters: %d%n",allPullovers );
        }


    }
}

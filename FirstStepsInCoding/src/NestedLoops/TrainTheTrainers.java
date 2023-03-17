package NestedLoops;

import java.util.Scanner;

public class TrainTheTrainers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        double allGradesSum = 0;
        int counter = 0;
        String input = scanner.nextLine();
        while (!input.equals("Finish")) {
            String name = input;
            double currentGradeSum = 0;
            for (int i = 0; i < n; i++) {
                double grade = Double.parseDouble(scanner.nextLine());
                counter++;
                currentGradeSum += grade;
            }
            allGradesSum += currentGradeSum;


            System.out.printf("%s - %.2f.%n", name, currentGradeSum / n);

            input = scanner.nextLine();
        }

        System.out.printf("Student's final assessment is %.2f.", allGradesSum / counter);
    }

}





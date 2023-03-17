package ForLoop;

import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int countStudentsExam = Integer.parseInt(scanner.nextLine());


        int g1 = 0;
        int g2 = 0;
        int g3 = 0;
        int g4 = 0;
        double total =0;
        for (int i = 1; i <= countStudentsExam; i++) {
            double grade = Double.parseDouble(scanner.nextLine());
            total += grade;
            if (grade <= 2.99) {
                g1 += 1;

            } else if (grade <= 3.99) {
                g2 += 1;

            } else if (grade <= 4.99) {
                g3 += 1;

            } else {
                g4 += 1;

            }
        }
        System.out.printf("Top students: %.2f%%%n", g4 * 1.0/ countStudentsExam * 100);
        System.out.printf("Between 4.00 and 4.99: %.2f%%%n", g3 * 1.0 / countStudentsExam * 100);
        System.out.printf("Between 3.00 and 3.99: %.2f%%%n", g2 * 1.0 / countStudentsExam * 100);
        System.out.printf("Fail: %.2f%%%n", g1 * 1.0 / countStudentsExam * 100);
        System.out.printf("Average: %.2f", total/countStudentsExam);
    }
}


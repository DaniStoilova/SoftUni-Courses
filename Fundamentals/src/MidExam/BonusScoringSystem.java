package MidExam;

import java.util.Scanner;

public class BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfStudents = Integer.parseInt(scanner.nextLine());
        int numberOfLecture = Integer.parseInt(scanner.nextLine());
        int additionalBonus = Integer.parseInt(scanner.nextLine());

        double max = 0;
        int point = 0;

        for (int i = 1; i <= numberOfStudents; i++) {
            int attendanceOfEachStudent = Integer.parseInt(scanner.nextLine());

            double totalBonus = ((attendanceOfEachStudent * 1.0 / numberOfLecture) * (5 + additionalBonus));


                if (totalBonus > max) {
                    max = totalBonus;

                    point = attendanceOfEachStudent;
                }


            }
            System.out.printf("Max Bonus: %.0f.%n", max);
            System.out.printf("The student has attended %d lectures.%n", point);
        }
    }

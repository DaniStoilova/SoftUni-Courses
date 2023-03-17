package MidExam;

import java.util.Scanner;

public class SoftUniReception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int employeeEfficiency = Integer.parseInt(scanner.nextLine());
        int employeeEfficiency1 = Integer.parseInt(scanner.nextLine());
        int employeeEfficiency2 = Integer.parseInt(scanner.nextLine());
        int studentsCount = Integer.parseInt(scanner.nextLine());

        int totalPerHour = employeeEfficiency + employeeEfficiency1 + employeeEfficiency2;

        int hours = 0;
        while (studentsCount > 0) {
           hours++;

            if (hours % 4 == 0) {

                continue;

            }
            studentsCount -= totalPerHour;


        }


        System.out.printf("Time needed: %dh.%n", hours);


    }
}

package MoreExercises;

import java.util.Scanner;

public class FootballLeague {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int stadiumCapacity = Integer.parseInt(scanner.nextLine());
        int countFens = Integer.parseInt(scanner.nextLine());

        int fensA = 0;
        int fensB = 0;
        int fensV = 0;
        int fensG = 0;
        for (int i = 1; i <= countFens; i++) {
            String sector = scanner.nextLine();
            if (sector.equals("A")) {
                fensA += 1;
            } else if (sector.equals("B")) {
                fensB += 1;
            } else if (sector.equals("V")) {
                fensV += 1;
            } else if (sector.equals("G")) {
                fensG += 1;
            }
        }
        System.out.printf("%.2f%%%n", fensA * 1.0 / countFens * 100);
        System.out.printf("%.2f%%%n", fensB * 1.0 / countFens * 100);
        System.out.printf("%.2f%%%n", fensV * 1.0 / countFens * 100);
        System.out.printf("%.2f%%%n", fensG * 1.0 / countFens * 100);
        System.out.printf("%.2f%%%n", countFens * 1.0 / stadiumCapacity * 100);

    }
}

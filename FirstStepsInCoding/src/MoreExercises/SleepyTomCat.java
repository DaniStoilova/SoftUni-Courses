package MoreExercises;

import java.util.Scanner;

public class SleepyTomCat {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int countDayOff = Integer.parseInt(scanner.nextLine());

        int year =  365;
        int dayOff = countDayOff * 127;
        int workDayMin = (year- countDayOff) * 63;

        int total = dayOff + workDayMin;

        int totalTimePlay = 30000 - total;

        int h = Math.abs(totalTimePlay/60);
        int min = Math.abs(totalTimePlay%60);

        if (30000 < total){
            System.out.println("Tom will run away");
            System.out.printf("%d hours and %d minutes more for play", h, min);
        }else{
            System.out.println("Tom sleeps well");
            System.out.printf("%d hours and %d minutes less for play", h, min);

        }

    }
}

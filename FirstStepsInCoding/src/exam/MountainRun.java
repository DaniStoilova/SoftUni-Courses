package exam;

import java.util.Scanner;

public class MountainRun {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        double record = Double.parseDouble(scanner.nextLine());
        double distanceMeter = Double.parseDouble(scanner.nextLine());
        double timeSeconds = Double.parseDouble(scanner.nextLine());

        double timeDistance = distanceMeter * timeSeconds;
        double timeResistense = Math.floor(distanceMeter/50) * 30;
        double totalTime = timeDistance + timeResistense;

        if(record <= totalTime){
            System.out.printf("No! He was %.2f seconds slower.", Math.abs(record - totalTime));
        }else{
            System.out.printf("Yes! The new record is %.2f seconds.", totalTime);
        }

    }

}

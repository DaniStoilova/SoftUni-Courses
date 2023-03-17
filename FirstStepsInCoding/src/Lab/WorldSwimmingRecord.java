package Lab;

import java.util.Scanner;

public class WorldSwimmingRecord {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        double worldRecord = Double.parseDouble(scanner.nextLine());
        double distance= Double.parseDouble(scanner.nextLine());
        double timeForUnitDistance= Double.parseDouble(scanner.nextLine());
        // distance 1500 ; timeforUnitDistance 20
        double allTime = distance * timeForUnitDistance;
        double resistanceTime = Math.floor(distance/15) * 12.50;

        double allTimePlusResistance = allTime + resistanceTime;
        double diff = allTimePlusResistance - worldRecord;
        if(allTimePlusResistance < worldRecord) {
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.", allTimePlusResistance);

        }else {
            System.out.printf("No, he failed! He was %.2f seconds slower.", diff);
        }

    }
}

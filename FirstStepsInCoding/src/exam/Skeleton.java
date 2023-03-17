package exam;

import java.util.Scanner;

public class Skeleton {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        int minute = Integer.parseInt(scanner.nextLine());
        int second = Integer.parseInt(scanner.nextLine());
        double length = Double.parseDouble(scanner.nextLine());
        int second100Meter = Integer.parseInt(scanner.nextLine());


        int totalSecond = minute * 60 + second;
        double time = length/120 * 2.5;
        double timeMarin = (length/100)*second100Meter-time;

        if(timeMarin <= totalSecond) {
            System.out.printf("Marin Bangiev won an Olympic quota!%n");
            System.out.printf("His time is %.3f.", timeMarin);
        }else{
            System.out.printf("No, Marin failed! He was %.3f second slower.", Math.abs(timeMarin-totalSecond));
        }
    }
}

package Exam1;

import java.util.Scanner;

public class P02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        double wide = Double.parseDouble(scanner.nextLine());
        double length = Double.parseDouble(scanner.nextLine());
        double high = Double.parseDouble(scanner.nextLine());
        double averageHigh = Double.parseDouble(scanner.nextLine());

        double volume = wide * length * high;

        double volumeRoom = (averageHigh + 0.40)* 2 *2;

        double place =Math.floor(volume/volumeRoom);

        if (place >= 3 && place <= 10){
            System.out.printf("The spacecraft holds %.0f astronauts.", place);
        }else if (place < 3){
            System.out.printf("The spacecraft is too small.");
        }else if (place > 10){
            System.out.printf("The spacecraft is too big.");
        }






    }
}

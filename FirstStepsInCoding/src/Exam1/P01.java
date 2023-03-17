package Exam1;

import java.util.Scanner;

public class P01 {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        double speed = Double.parseDouble(scanner.nextLine());
        double litre = Double.parseDouble(scanner.nextLine());

        int distance = 384400;

        int allDistance = distance * 2;
        double time  = Math.ceil(allDistance/speed);

        double totalTime = time + 3;

        double totalLitre = allDistance*litre/100;

        System.out.printf("%.0f%n", totalTime);
        System.out.printf("%.0f",totalLitre);







    }
}

package Lab;

import java.util.Scanner;

public class BonusPoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int intPoint = Integer.parseInt(scanner.nextLine());
        double bonusPoints = 0;


        if (intPoint <= 100){
        bonusPoints = 5;
        }else if (intPoint <= 1000) {
            bonusPoints = intPoint * 0.20;
        }else {
            bonusPoints = intPoint * 0.10;
        }
        if (intPoint % 2 == 0){
            bonusPoints = bonusPoints + 1;
        }
        if (intPoint % 10 == 5){
            bonusPoints = bonusPoints +2;
        }
        System.out.println(bonusPoints);
        System.out.println(intPoint + bonusPoints);

        }
}

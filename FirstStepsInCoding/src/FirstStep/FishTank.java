package FirstStep;

import java.util.Scanner;

public class FishTank {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        int wide = Integer.parseInt(scanner.nextLine());
        int high = Integer.parseInt(scanner.nextLine());
        double percentAcc = Double.parseDouble(scanner.nextLine());
        int volumeCm = length * wide * high;
        double volumeLitre = volumeCm / 1000.0;
        double totalLitre = volumeLitre - (volumeLitre * percentAcc/100.0);
        System.out.println(totalLitre);






    }
}

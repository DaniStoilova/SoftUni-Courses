package exam;

import java.util.Scanner;

public class PoolDay {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int countPeople = Integer.parseInt(scanner.nextLine());
        double tax = Double.parseDouble(scanner.nextLine());
        double onePlace = Double.parseDouble(scanner.nextLine());
        double oneUmbrella = Double.parseDouble(scanner.nextLine());

        double taxEntrance = countPeople * tax;
        double totalPlace = Math.ceil(countPeople * 0.75) * onePlace;
        double totalUmbrella = Math.ceil(countPeople * 0.50) * oneUmbrella;

        double totalSum = taxEntrance + totalPlace + totalUmbrella;

        System.out.printf("%.2f lv.", totalSum);

    }
}

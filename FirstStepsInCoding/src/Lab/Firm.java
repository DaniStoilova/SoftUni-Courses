package Lab;

import java.util.Scanner;

public class Firm {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int hour = Integer.parseInt(scanner.nextLine());
        int days = Integer.parseInt(scanner.nextLine());
        int countPeopleBonus = Integer.parseInt(scanner.nextLine());

        double dayWithoutTraining = days - (days * 0.10);
        double workHours = dayWithoutTraining * 8;
        int bonusHours = countPeopleBonus * (2 * days);
        double totalHours = Math.floor(workHours + bonusHours);

        double diff = Math.abs(totalHours - hour);
        if (totalHours >= hour){
            System.out.printf("Yes!%.0f hours left.", diff);
        }else{
            System.out.printf("Not enough time!%.0f hours needed.", diff);
        }

    }
}

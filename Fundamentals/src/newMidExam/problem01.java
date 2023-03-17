package newMidExam;

import java.util.Scanner;

public class problem01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double amount = Double.parseDouble(scanner.nextLine());
        int countOfBattles = Integer.parseInt(scanner.nextLine());

        double sum = 0;
        int count = 0;
        for (int i = 1; i <= countOfBattles; i++) {
            double experiencePerBattles = Double.parseDouble(scanner.nextLine());
            if (sum >= amount){

                break;
            }
            sum += experiencePerBattles;
            count++;


            if (i % 3 == 0) {
                experiencePerBattles = (experiencePerBattles * 0.15);
                sum += experiencePerBattles;
            }
            if (i % 5 == 0) {
                experiencePerBattles = (experiencePerBattles * 0.10);
                sum -= experiencePerBattles;
            }
//            if (i % 15 == 0) {
//                experiencePerBattles = (experiencePerBattles * 0.05);
//                sum += experiencePerBattles;
//            }


        }
        if (sum >= amount) {
            System.out.printf("Player successfully collected his needed experience for %d battles.%n", count);
        } else {
            System.out.printf("Player was not able to collect the needed experience, %.2f more needed.%n", amount - sum);
        }


    }
}

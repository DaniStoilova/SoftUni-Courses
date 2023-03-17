package ForLoop;

import java.util.Scanner;

public class TennisRankList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countTour = Integer.parseInt(scanner.nextLine());
        int pointRangList = Integer.parseInt(scanner.nextLine());


        int points = 0;
        int win = 0;
        for (int i = 1; i <= countTour; i++) {
            String type = scanner.nextLine();
            if (type.equals("W")) {
                points += 2000;
                win++;
            } else if (type.equals("F")) {
                points += 1200;
            } else if (type.equals("SF")) {
                points += 720;

            }
        }
        double percentWin = win * 1.0 / countTour * 100;
        int totalPoints = pointRangList + points;

        System.out.printf("Final points: %d%n", totalPoints);
        System.out.printf("Average points: %d%n", points / countTour);
        System.out.printf("%.2f%%%n", percentWin);

    }
}

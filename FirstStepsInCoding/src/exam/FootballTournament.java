package exam;

import java.util.Scanner;

public class FootballTournament {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nameTeam = scanner.nextLine();
        int countMeetings = Integer.parseInt(scanner.nextLine());

        int pointsW = 0;
        int pointsD = 0;
        int points = 0;
        int countW = 0;
        int countD = 0;
        int countL = 0;
        int total = 0;

        for (int i = 0; i < countMeetings; i++) {
            String symbol = scanner.nextLine();

            switch (symbol) {
                case "W":
                    points = 3;
                    countW++;
                    pointsW = points * countW;
                    break;
                case "D":
                    points = 1;
                    countD++;
                    pointsD = points * countD;
                    break;
                case "L":
                    countL++;
                    break;
                default:
                    break;
            }
        }
        total = pointsW + pointsD;
        if (countMeetings > 1) {
            System.out.printf("%s has won %d points during this season.%n",nameTeam,total );
            System.out.printf("Total stats:%n");
            System.out.printf("## W: %d%n", countW);
            System.out.printf("## D: %d%n", countD);
            System.out.printf("## L: %d%n", countL);
            System.out.printf("Win rate: %.2f%%%n", countW * 1.0/countMeetings*100);
        }else{
            System.out.printf("%s hasn't played any games during this season.", nameTeam);
        }

    }
}

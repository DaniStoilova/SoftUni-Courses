package exam;

import java.util.Scanner;

public class TournamentOfChristmas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countDays = Integer.parseInt(scanner.nextLine());

        double sum = 0;
        int totalWin = 0;
        int totalLose = 0;
        double price = 0;
        for (int i = 1; i <= countDays; i++) {
            String input = scanner.nextLine();
            int win = 0;
            int lose = 0;
            double total = 0;
            while (!input.equals("Finish")) {
                String sport = input;
                String result = scanner.nextLine();

                if (result.equals("win")) {
                    price = 20;
                    win++;
                    totalWin++;
                } else if (result.equals("lose")) {
                    lose++;
                    totalLose++;
                    price = 0;
                }
                total += price;
                input = scanner.nextLine();
            }
            if (win > lose) {
                total = total * 1.10;
            }
            if (totalWin > totalLose) {
                total = total * 1.2;
            }

            sum += total;

        }

            if (totalWin > totalLose) {
                System.out.printf("You won the tournament! Total raised money: %.2f", sum);
            } else {
                System.out.printf("You lost the tournament! Total raised money: %.2f", sum);
            }
    }

}




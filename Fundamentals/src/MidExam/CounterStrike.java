package MidExam;

import java.util.Scanner;

public class CounterStrike {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int initialEnergy = Integer.parseInt(scanner.nextLine());

        String inputLine = scanner.nextLine();

        int battles = 0;
        while (!inputLine.equals("End of battle")) {
            int distance = Integer.parseInt(inputLine);
            if (initialEnergy >= distance) {
                battles++;
                initialEnergy -= distance;

            } else if (initialEnergy < distance) {

                System.out.printf("Not enough energy! Game ends with %d won battles and %d energy%n", battles, initialEnergy);
                return;
            }
            if (battles % 3 == 0) {
                initialEnergy += battles;
            }
                inputLine = scanner.nextLine();
            }

        if (inputLine.equals("End of battle")) {
            System.out.printf("Won battles: %d. Energy left: %d%n", battles, initialEnergy);
        }
    }
}

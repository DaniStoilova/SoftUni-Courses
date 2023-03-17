package exam;

import java.util.Scanner;

public class EasterCompetition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countCake = Integer.parseInt(scanner.nextLine());

        int max = Integer.MIN_VALUE;
        String maxName = "";
        for (int i = 1; i <= countCake; i++) {
            int points = 0;
            String name = scanner.nextLine();
            String input = scanner.nextLine();
            while (!input.equals("Stop")) {
                int grade = Integer.parseInt(input);

                points += grade;

                input = scanner.nextLine();
            }
            System.out.printf("%s has %d points.%n", name, points);
            if (max < points) {
                max = points;
                maxName = name;
                System.out.printf("%s is the new number 1!%n", name);
            }
    }
        System.out.printf("%s won competition with %d points!%n",maxName,max);

}
}

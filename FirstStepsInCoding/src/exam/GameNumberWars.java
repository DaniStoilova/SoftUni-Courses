package exam;

import java.util.Scanner;

public class GameNumberWars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int pointsFirst = 0;
        int pointsSecond = 0;
        int points = 0;
        String n = "";
        String name = scanner.nextLine();
        String nameSecond = scanner.nextLine();
        String input = scanner.nextLine();
        while (!input.equals("End of game")) {

            int first = Integer.parseInt(input);
            int second = Integer.parseInt(scanner.nextLine());
            if (first > second) {
                pointsFirst = pointsFirst + first - second;



            } else if (first < second) {
                pointsSecond = pointsSecond + second - first;

            } else if (first == second) {
                int first1 = Integer.parseInt(scanner.nextLine());
                int second2 = Integer.parseInt(scanner.nextLine());
                if (first1 > second2) {
                    points = pointsFirst;
                    n = name;
                    break;
                } else {
                    points = pointsSecond;
                    n = nameSecond;
                    break;
                }
            }
            input = scanner.nextLine();
        }

        if (input.equals("End of game")) {
            System.out.printf("Elena has %d points%n", pointsFirst);
            System.out.printf("Simeon has %d points", pointsSecond);
        }else{
            System.out.println("Number wars!");
            System.out.printf("%s is winner with %d points", n,points );

        }
    }
}




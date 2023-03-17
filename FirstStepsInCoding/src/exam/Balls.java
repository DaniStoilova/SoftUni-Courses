package exam;

import java.util.Scanner;

public class Balls {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int red = 0;
        int orange = 0;
        int yellow = 0;
        int white = 0;
        int black = 0;
        int other = 0;
        int points = 0;

        for (int i=1; i <= n; i++){
            String color = scanner.nextLine();

            switch (color){

                case "red":
                    red++;
                points = points + 5;
                    break;
                case "orange":
                    orange++;
                    points = points + 10;
                    break;
                case "yellow":
                    yellow++;
                    points = points + 15;
                    break;
                case "white":
                    white++;
                    points = points + 20;
                    break;
                case "black":
                    black++;
                    points = (int)Math.floor(points/2);
                    break;
                default:
                case "!Other":
                    other++;
                    break;

            }

        }
            System.out.printf("Total points: %d%n",points);
            System.out.printf("Red balls: %d%n",red);
            System.out.printf("Orange balls: %d%n", orange);
            System.out.printf("Yellow balls: %d%n", yellow);
            System.out.printf("White balls: %d%n", white);
            System.out.printf("Other colors picked: %d%n",other );
            System.out.printf("Divides from black balls: %d%n", black);
    }
}

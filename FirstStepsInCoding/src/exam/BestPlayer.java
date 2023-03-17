package exam;

import java.util.Scanner;

public class BestPlayer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String namePlayer = "";
        int goal = Integer.MIN_VALUE;

        String name = scanner.nextLine();

        while (!name.equals("END")) {
            int countGoal = Integer.parseInt(scanner.nextLine());
            if (goal < countGoal){
            goal = countGoal;
            namePlayer = name;
        }
            if (countGoal >= 10) {
                break;
            }

        name = scanner.nextLine();

        }
            if (goal >= 3){
                System.out.printf("%s is the best player!%n", namePlayer);
                System.out.printf("He has scored %d goals and made a hat-trick !!!",goal );
            }else {
                System.out.printf("%s is the best player!%n", namePlayer);
                System.out.printf("He has scored %d goals.",goal );
        }

        }

    }


package exam;

import java.util.Scanner;

public class Darts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        int startPoints = 301;
        int totalPoints = 0;
        int shots = 0;
        int shotsn= 0;
        String input = scanner.nextLine();
        while (!input.equals("Retire")) {
            String pole = input;
            int point = Integer.parseInt(scanner.nextLine());

            switch (pole) {
                case "Single":
                    totalPoints = point;
                    break;
                case "Double":
                    totalPoints = point * 2;
                    break;
                case "Triple":
                    totalPoints =(point * 3);
                    break;
            }

            if (totalPoints > startPoints){
                shotsn++;
            }else if (totalPoints <= startPoints){
                shots++;
                startPoints -= totalPoints;
                if (startPoints == 0) {
                    break;
                }

            }
            input = scanner.nextLine();
        }
        if (startPoints != 0){
            System.out.printf("%s retired after %d unsuccessful shots.", name,shotsn);
        }else{
            System.out.printf("%s won the leg with %d shots.",name,shots);
        }

    }

}


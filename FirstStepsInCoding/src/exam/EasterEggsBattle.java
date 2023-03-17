package exam;

import java.util.Scanner;

public class EasterEggsBattle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countFirst = Integer.parseInt(scanner.nextLine());
        int countSecond = Integer.parseInt(scanner.nextLine());


        String input = scanner.nextLine();
        while (!input.equals("End of battle")) {
            String winner = input;
            if (winner.equals("one")) {
                countSecond -= 1;
            } else if (winner.equals("two")) {
                countFirst -= 1;
            }
            if (countFirst == 0 || countSecond == 0) {
                break;
            }


            input = scanner.nextLine();
        }
        if (input.equals("End of battle")) {
            System.out.printf("Player one has %d eggs left.%n", countFirst);
            System.out.printf("Player two has %d eggs left.%n", countSecond);
        } else if(countFirst == 0) {
            System.out.printf("Player one is out of eggs. Player two has %d eggs left.", countSecond);
        }else if (countSecond == 0){
            System.out.printf("Player two is out of eggs. Player one has %d eggs left.", countFirst);
        }
    }
}

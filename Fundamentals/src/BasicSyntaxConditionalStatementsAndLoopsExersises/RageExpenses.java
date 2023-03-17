package BasicSyntaxConditionalStatementsAndLoopsExersises;

import java.util.Scanner;

public class RageExpenses {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
            // headset, mouse, keyboard and display

        int  lostGamesCount = Integer.parseInt(scanner.nextLine());
        double headsetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice  = Double.parseDouble(scanner.nextLine());
        double keyboardPrice  = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());

        int countHeadset = lostGamesCount/2;
        int countMouse = lostGamesCount/3;
        int countKeyboard = lostGamesCount/6;
        int countDisplay = lostGamesCount/12;


        double expenses = (headsetPrice * countHeadset)
                + (mousePrice * countMouse)
                + (keyboardPrice * countKeyboard)
                + (displayPrice * countDisplay);

        System.out.printf("Rage expenses: %.2f lv.", expenses);

    }
}

package WorkingWthAbstractionExercise.CardsWithPower.CardRank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        System.out.println("Card Ranks:");
//        for (Ranks ranks : Ranks.values()) {
//            System.out.printf("Ordinal value: %d; Name value: %s%n", ranks.ordinal(), ranks.name());
//        }

        Ranks ranks = Ranks.valueOf(scanner.nextLine());
        Suit suit = Suit.valueOf(scanner.nextLine());

        int cardPower = ranks.getPower() + suit.getPower();

        System.out.printf("Card name: %s of %s; Card power: %d",ranks.name(),suit.name(),cardPower);




    }
}

package WorkingWthAbstractionExercise.CardRank.CardRank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Card Ranks:");
        for (Ranks ranks : Ranks.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", ranks.ordinal(), ranks.name());
        }


    }
}

package ListExersises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstPlayerCards = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> secondPlayerCards = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while (firstPlayerCards.size() != 0 && secondPlayerCards.size() != 0) {
            int firstCard = firstPlayerCards.get(0);
            int secondCard = secondPlayerCards.get(0);
            firstPlayerCards.remove(0);
            secondPlayerCards.remove(0);

            if (firstCard > secondCard) {
                firstPlayerCards.add(firstCard);
                firstPlayerCards.add(secondCard);
            } else if (secondCard > firstCard) {
                secondPlayerCards.add(secondCard);
                secondPlayerCards.add(firstCard);
            }
                if (firstPlayerCards.size() == 0) {
                    System.out.printf("Second player wins! Sum: %d", getCardSum(secondPlayerCards));
                } else if (secondPlayerCards.size() == 0) {
                    System.out.printf("First player wins! Sum: %d", getCardSum(firstPlayerCards));
                }



        }


    }

    private static int getCardSum(List<Integer> listCards) {

        int sum = 0;
        for (int card : listCards) {
            sum += card;
        }
        return sum;
    }
}

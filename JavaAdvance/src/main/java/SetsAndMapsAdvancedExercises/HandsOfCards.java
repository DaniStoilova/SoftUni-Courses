package SetsAndMapsAdvancedExercises;

import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        LinkedHashMap<String, HashSet<String>> map = new LinkedHashMap<>();

        while (!input.equals("JOKER")) {
            String[] parts = input.split(": ");
            String namePlayer = parts[0];
            String[] cards = parts[1].split(", ");

            if (!map.containsKey(namePlayer)) {
                map.put(namePlayer, new HashSet<>());
            }

//            for (int i = 0; i < cards.length; i++) {
//                String currentCard = cards[i];
//                map.get(namePlayer).add(currentCard);
//
//            }
            Collections.addAll(map.get(namePlayer), cards);


            input = scanner.nextLine();
        }

        for (Map.Entry<String, HashSet<String>> entry : map.entrySet()) {
            String name = entry.getKey();
            int point = calculate(entry.getValue());

            System.out.printf("%s: %d%n",name,point);
        }


    }

    private static int calculate(HashSet<String> cards) {
        int point = 0;
        for (String card : cards) {
            String power = card.substring(0, card.length() - 1);
            String color = card.substring(card.length() - 1);

            int cardPoint = getPower(power) * getColor(color);
            point += cardPoint;
        }

        return point;
    }

    private static int getColor(String color) {
        switch (color) {
            case "S":
                return 4;

            case "H":
                return 3;

            case "D":
                return 2;

            case "C":
                return 1;

        }
        return 0;

    }

    private static int getPower(String power) {
        switch (power) {
            case "2":
                return 2;

            case "3":
                return 3;

            case "4":
                return 4;

            case "5":
                return 5;

            case "6":
                return 6;

            case "7":
                return 7;

            case "8":
                return 8;

            case "9":
                return 9;

            case "10":
                return 10;

            case "J":
                return 11;

            case "Q":
                return 12;

            case "K":
                return 13;

            case "A":
                return 14;


        }
        return 0;

    }
}

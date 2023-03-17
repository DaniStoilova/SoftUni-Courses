package RegularExpressionsExercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        String regex = "@(?<namePlanet>[A-Za-z]+)[^@!:>-]*:(?<population>\\d+)[^@!:>-]*!(?<attackType>[AD])![^@!:>-]*->(?<soldierCount>\\d+)";

        Pattern pattern = Pattern.compile(regex);

        List<String> attackPlanet = new ArrayList<>();
        List<String> destroyedPlanet = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String encryptedMessage = scanner.nextLine();
            String decryptedMessage = getDecryptedMessage(encryptedMessage);

            Matcher matcher = pattern.matcher(decryptedMessage);
            if (matcher.find()) {
                String namePlanet = matcher.group("namePlanet");
                // int population =Integer.parseInt(matcher.group("population"));
                String attackType = matcher.group("attackType");
                // int solderCCount = Integer.parseInt(matcher.group("soldierCount"));

                if (attackType.equals("A")) {
                    attackPlanet.add(namePlanet);
                } else if (attackType.equals("D")) {
                    destroyedPlanet.add(namePlanet);
                }
            }
        }
        System.out.println("Attacked planets: " + attackPlanet.size());
        Collections.sort(attackPlanet);
        attackPlanet.forEach(planet -> System.out.println("-> " + planet));

        System.out.println("Destroyed planets: " + destroyedPlanet.size());
        Collections.sort(destroyedPlanet);
        destroyedPlanet.forEach(planet -> System.out.println("-> " + planet));

    }

    private static String getDecryptedMessage(String encryptedMessage) {

        int countLetters = getLettersCount(encryptedMessage);

        StringBuilder decryptedText = new StringBuilder();

        for (char symbol : encryptedMessage.toCharArray()) {
            char newSymbol = (char) (symbol - countLetters);
            decryptedText.append(newSymbol);
        }


        return decryptedText.toString();


    }

    private static int getLettersCount(String encryptedMessage) {

        int count = 0;

        for (char symbol : encryptedMessage.toCharArray()) {
            switch (symbol) {
                case 's':
                case 't':
                case 'a':
                case 'r':
                case 'S':
                case 'T':
                case 'A':
                case 'R':
                    count++;
                    break;

            }
        }
        return count;
    }
}

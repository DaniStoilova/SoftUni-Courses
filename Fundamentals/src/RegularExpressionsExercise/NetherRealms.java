package RegularExpressionsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class NetherRealms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> demonNames = Arrays
                .stream(scanner.nextLine().split("\\s*,\\s*"))
                .collect(Collectors.toList());

        Pattern patternHealth = Pattern.compile("[^0-9+\\-*\\/.]");

        Pattern patternDamage = Pattern.compile("\\-?\\+?[0-9]+[\\.]?[0-9]*");

        for (String demon : demonNames) {
            Matcher matcherHealth = patternHealth.matcher(demon);

            int health = 0;
            while (matcherHealth.find()) {
                char symbol = matcherHealth.group().charAt(0);

                health += symbol;
            }
            Matcher matcherDamage = patternDamage.matcher(demon);
            double damage = 0;
            while (matcherDamage.find()) {
                damage += Double.parseDouble(matcherDamage.group());
            }
            for (char symbol : demon.toCharArray()) {
                if (symbol == '/') {
                    damage /= 2;
                } else if (symbol == '*') {
                    damage *= 2;
                }
            }


            System.out.printf("%s - %d health, %.2f damage%n", demon, health, damage);


        }


    }
}

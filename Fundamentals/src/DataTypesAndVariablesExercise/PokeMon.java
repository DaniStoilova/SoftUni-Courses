package DataTypesAndVariablesExercise;

import java.util.Scanner;

public class PokeMon {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        int pokePower = Integer.parseInt(scanner.nextLine());
        int pokeDistance = Integer.parseInt(scanner.nextLine());
        int exhaustionFactor = Integer.parseInt(scanner.nextLine());

        int countPoke = 0;
        int firstTimePower = pokePower;
        while (pokePower >= pokeDistance){
            pokePower -= pokeDistance;
            countPoke++;

            if (pokePower == firstTimePower * 0.5){
                if (exhaustionFactor > 0){
                    pokePower = pokePower/exhaustionFactor;
                }

            }
        }
        System.out.println(pokePower);
        System.out.println(countPoke);
    }
}

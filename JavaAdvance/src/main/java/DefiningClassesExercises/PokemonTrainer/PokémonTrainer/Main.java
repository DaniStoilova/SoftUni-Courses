package DefiningClassesExercises.PokemonTrainer.PokémonTrainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Pokemon> list = new ArrayList<>();
        Map<String, Trainer> map = new LinkedHashMap<>();

        int count = 0;
        int countPokemon = 0;
        while (!input.equals("Tournament")) {

            String[] data = input.split(" ");

            String nameTrainer = data[0];
            String namePokemon = data[1];
            String elementPokemon = data[2];
            int pokemonHealth = Integer.parseInt(data[3]);

            Pokemon pokemon = new Pokemon(namePokemon, elementPokemon, pokemonHealth);

            Trainer trainer = new Trainer(nameTrainer, 0, list);

            if (!map.containsKey(nameTrainer)) {
                map.putIfAbsent(nameTrainer, new Trainer(nameTrainer, 0, new ArrayList<>()));
                map.get(nameTrainer).getPokemon().add(pokemon);
            } else {
                map.get(nameTrainer).getPokemon().add(pokemon);
            }

            input = scanner.nextLine();
        }
        String command = scanner.nextLine();

        while (!command.equals("End")) {

            boolean isFound = false;

            for (Map.Entry<String, Trainer> entry : map.entrySet()) {
                for (Pokemon pokemon : entry.getValue().getPokemon()) {
                    if (pokemon.getElement().equals(command)) {
                        entry.getValue().setNumberOfBadges();
                        isFound = true;
                        break;
                    } else {
                        pokemon.setHealth();

                    }
                    if (pokemon.getHealth() <= 0) {
                        entry.getValue().getPokemon().remove(pokemon);
                        if (entry.getValue().getPokemon().size() < 1) {
                            break;
                        }
                    }

                }


            }
            command = scanner.nextLine();
        }

        map.entrySet().stream().sorted((f,s) -> Integer.compare(s.getValue().getNumberOfBadges(),
                f.getValue().getNumberOfBadges()))
                .forEach(t -> {
                    System.out.printf("%s %d %d%n", t.getKey(),
                            t.getValue().getNumberOfBadges(), t.getValue().getPokemon().size());
                });


//        for (Map.Entry<String, Trainer> entry : map.entrySet()) {
//            for (Pokemon pokemon : entry.getValue().getPokemon()) {
//
//            }
//            System.out.printf("%s %d %d%n", entry.getKey(),
//                    entry.getValue().getNumberOfBadges(), entry.getValue().getPokemon().size());
//        }

    }
}

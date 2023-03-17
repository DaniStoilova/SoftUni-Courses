package ExamPreparation;

import java.util.*;

public class HeroesOfCodeAndLogicVII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Integer>> mapHeroes = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String heroName = input[0];
            int hitPoint = Integer.parseInt(input[1]);
            int manaPoint = Integer.parseInt(input[2]);

            mapHeroes.putIfAbsent(heroName, new ArrayList<>());

            mapHeroes.get(heroName).add(0, hitPoint);
            mapHeroes.get(heroName).add(1, manaPoint);


        }

        String command = scanner.nextLine();

        while (!command.equals("End")) {
            String[] line = command.split(" - ");
            String commandLine = line[0];


            String name = line[1];
            int HP = mapHeroes.get(name).get(0);
            int MP = mapHeroes.get(name).get(1);

            switch (commandLine) {
                case "CastSpell":
                    int mpNeeded = Integer.parseInt(line[2]);
                    String spellName = line[3];

                    if (MP >= mpNeeded) {

                        mapHeroes.get(name).set(1, MP - mpNeeded);
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n", name, spellName, MP - mpNeeded);
                    } else {
                        System.out.printf("%s does not have enough MP to cast %s!%n", name, spellName);
                    }
                    break;
                case "TakeDamage":
                    int damage = Integer.parseInt(line[2]);
                    String attacker = line[3];

                    int current = HP - damage;

                    mapHeroes.get(name).set(0, current);

                    if (current > 0) {
                        System.out.printf("%s was hit for %d HP by " +
                                "%s and now has %d HP left!%n", name, damage, attacker, current);
                    } else {
                        System.out.printf("%s has been killed by %s!%n", name, attacker);
                        mapHeroes.remove(name);
                    }

                    break;
                case "Recharge":
                    int amount = Integer.parseInt(line[2]);

                    int currentMP = MP + amount;

                    int diff = 0;
                    if (currentMP > 200) {
                        diff = 200 - MP;
                        currentMP = 200;
                    } else {
                        diff = amount;

                    }
                    mapHeroes.get(name).set(1, currentMP);
                    System.out.printf("%s recharged for %d MP!%n", name, diff);

                    break;
                case "Heal":
                    int amountHeal = Integer.parseInt(line[2]);

                    int currentHP = HP + amountHeal;

                    int diffHeal = 0;
                    if (currentHP > 100) {
                        diffHeal = 100 - HP;
                        currentHP = 100;
                    } else {
                        diffHeal = amountHeal;

                    }

                    mapHeroes.get(name).set(0, currentHP);
                    System.out.printf("%s healed for %d HP!%n", name, diffHeal);


                    break;
            }


            command = scanner.nextLine();
        }

        for (Map.Entry<String, List<Integer>> entry : mapHeroes.entrySet()) {
            System.out.printf("%s%n", entry.getKey());
            System.out.printf("HP: %d%n", entry.getValue().get(0));
            System.out.printf("MP: %d%n", entry.getValue().get(1));
        }


    }
}

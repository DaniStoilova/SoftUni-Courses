package MidExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ManOWar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> pirateShip = Arrays
                .stream(scanner.nextLine().split("\\>"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> warShip = Arrays
                .stream(scanner.nextLine().split("\\>"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int maxHealth = Integer.parseInt(scanner.nextLine());
        boolean isStalemate = false;
        String input = scanner.nextLine();

        while (!input.equals("Retire")) {
            String[] command = input.split(" ");
            String line = command[0];

            switch (line) {
                case "Fire":
                    int index = Integer.parseInt(command[1]);
                    int damageFire = Integer.parseInt(command[2]);
                    if (index >= 0 && index <= warShip.size()) {
                        int warShipForDamage = warShip.get(index) - damageFire;
                        if (warShipForDamage <= 0) {
                            System.out.println("You won! The enemy ship has sunken.");
                            isStalemate = true;
                            break;
                        } else {
                            warShip.set(index, warShipForDamage);
                        }
                    }
                    break;
                case "Defend":
                    int startIndex = Integer.parseInt(command[1]);
                    int endIndex = Integer.parseInt(command[2]);
                    int damageDefend = Integer.parseInt(command[3]);
                    if (startIndex >= 0 && endIndex <= pirateShip.size()) {
                        for (int i = startIndex; i <= endIndex; i++) {
                            int pirateShipForDamage = pirateShip.get(i) - damageDefend;
                            if (pirateShipForDamage <= 0) {
                                System.out.println("You lost! The pirate ship has sunken.");
                                isStalemate = true;
                                break;
                            } else {
                                pirateShip.set(startIndex, pirateShipForDamage);
                                startIndex++;
                            }
                        }
                    }
                    break;
                case "Repair":
                    int repairIndex = Integer.parseInt(command[1]);
                    int health = Integer.parseInt(command[2]);
                    if (repairIndex >= 0 && repairIndex <= pirateShip.size()) {
                        if (health > maxHealth) {
                            health = maxHealth;
                            pirateShip.set(repairIndex, health);
                        } else {
                            int repairIndexForHealth = pirateShip.get(repairIndex) + health;
                            pirateShip.set(repairIndex, repairIndexForHealth);
                        }
                    }
                    break;
                case "Status":
                    double capacity = maxHealth * 0.20;
                    int count = 0;

                    for (int pirate : pirateShip) {

                        if (pirate < capacity) {
                            count++;

                        }
                    }
                    System.out.printf("%d sections need repair.%n", count);
                    break;
            }


            input = scanner.nextLine();
        }

        int sumPirate = 0;
        int sumWar = 0;

        if (!isStalemate) {
            for (int pirate : pirateShip) {
                sumPirate += pirate;

            }
            System.out.printf("Pirate ship status: %d%n", sumPirate);

            for (int war : warShip) {
                sumWar += war;

            }
            System.out.printf("Warship status: %d%n", sumWar);
        }

    }
}


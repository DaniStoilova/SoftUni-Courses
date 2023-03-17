package MidExam;

import java.util.Scanner;

public class MuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] roomArr = scanner.nextLine().split("\\|");

        boolean isDead = false;
        int health = 100;
        int bitcoins = 0;
        for (int i = 0; i < roomArr.length; i++) {
            String[] room = roomArr[i].split(" ");
            String command = room[0];
            int number = Integer.parseInt(room[1]);

            switch (command) {
                case "potion":
                    int diffHealth = 100 - health;
                    health = health + number;
                    if (health > 100) {
                        number = diffHealth;
                        health = 100;
                    }
                    System.out.printf("You healed for %d hp.%n", number);
                    System.out.printf("Current health: %d hp.%n", health);

                    break;
                case "chest":
                    System.out.printf("You found %d bitcoins.%n", number);
                    bitcoins += number;
                    break;
                default:
                    health = health - number;
                    if (health <= 0) {
                        isDead = true;
                        System.out.printf("You died! Killed by %s.%n", command);
                        System.out.printf("Best room: %d%n", i + 1);
                    } else {

                        System.out.printf("You slayed %s.%n", command);
                    }
                    break;

            }
            if (isDead) {
                break;
            }

        }
        if (!isDead) {
            System.out.println("You've made it!");
            System.out.printf("Bitcoins: %d%n", bitcoins);
            System.out.printf("Health: %d%n", health);
        }


    }
}

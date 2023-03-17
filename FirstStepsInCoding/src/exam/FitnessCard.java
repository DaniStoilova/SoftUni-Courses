package exam;

import java.util.Scanner;

public class FitnessCard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double sum = Double.parseDouble(scanner.nextLine());
        String gender = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String sport = scanner.nextLine();

        double price = 0;
        switch (sport) {
            case "Gym":
                if (gender.equals("m")) {
                    price = 42;
                } else if (gender.equals("f")) {
                    price = 35;
                }
                break;
            case "Boxing":
                if (gender.equals("m")) {
                    price = 41;
                } else if (gender.equals("f")) {
                    price = 37;
                }
                break;
            case "Yoga":
                if (gender.equals("m")) {
                    price = 45;
                } else if (gender.equals("f")) {
                    price = 42;
                }
                break;
            case "Zumba":
                if (gender.equals("m")) {
                    price = 34;
                } else if (gender.equals("f")) {
                    price = 31;
                }
                break;
            case "Dances":
                if (gender.equals("m")) {
                    price = 51;
                } else if (gender.equals("f")) {
                    price = 53;
                }
                break;
            case "Pilates":
                if (gender.equals("m")) {
                    price = 39;
                } else if (gender.equals("f")) {
                    price = 37;
                }
                break;

        }
        if (age <= 19){
            price = price * 0.80;
        }
        if (sum > price) {
            System.out.printf("You purchased a 1 month pass for %s.", sport);
        } else {
            System.out.printf("You don't have enough money! You need $%.2f more.", Math.abs(sum-price));
        }
    }
}
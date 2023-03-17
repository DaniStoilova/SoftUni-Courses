package MoreExercises;

import java.util.Locale;
import java.util.Scanner;

public class FuelTank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fuel = scanner.nextLine().toLowerCase(Locale.ROOT);
        double fuelLLitre = Double.parseDouble(scanner.nextLine());


        switch (fuel) {
            case "diesel":
            case "gasoline":
            case "gas":
                break;
        }
        if (fuelLLitre >= 25 && fuel.equals("diesel") || fuel.equals("gasoline") || fuel.equals("gas")) {
            System.out.printf("You have enough %s.", fuel);
        } else if (fuelLLitre < 25 && fuel.equals("diesel") || fuel.equals("gasoline") || fuel.equals("gas")) {
            System.out.printf("Fill your tank with %s!", fuel);
        } else {
                System.out.println("Invalid fuel!");
            }
        }
    }








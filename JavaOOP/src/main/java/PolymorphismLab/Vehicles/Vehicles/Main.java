package PolymorphismLab.Vehicles.Vehicles;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Vehicle> map = new LinkedHashMap<>();

        map.put("Car", getVehicles(scanner));
        map.put("Truck",getVehicles(scanner));


        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfCommands; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            String commands = tokens[0];
            String typeVehicle = tokens[1];
            double argument = Double.parseDouble(tokens[2]);


            switch (commands) {
                case "Drive":
                    System.out.println(map.get(typeVehicle).drive(argument));
                    break;
                case "Refuel":
                    map.get(typeVehicle).refuel(argument);
                    break;
            }


        }

        map.values().forEach(System.out::println);


    }


    private static Vehicle getVehicles(Scanner scanner) {
        String[] data = scanner.nextLine().split(" ");
        String type = data[0];
        double fuelQuantity = Double.parseDouble(data[1]);
        double fuelConsumption = Double.parseDouble(data[2]);
        switch (type) {
            case "Car":
                return new Car(fuelQuantity, fuelConsumption);
            case "Truck":
                return new Truck(fuelQuantity, fuelConsumption);
            default:
                throw new IllegalArgumentException("Missing car");
        }
    }
}


package PolymorphismLab.VehiclesExtension.Vehicles;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Vehicle> map = new LinkedHashMap<>();

        map.put("Car", getVehicles(scanner));
        map.put("Truck",getVehicles(scanner));
        map.put("Bus",getVehicles(scanner));


        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfCommands; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            String commands = tokens[0];
            String typeVehicle = tokens[1];
            double argument = Double.parseDouble(tokens[2]);


            switch (commands) {
                case "DriveEmpty":
                    System.out.println(map.get(typeVehicle).drive(argument));
                    break;
                case "Drive":
                    System.out.println(map.get(typeVehicle).driveAC(argument));
                    break;
                case "Refuel":
                    try {
                        map.get(typeVehicle).refuel(argument);
                    }catch (IllegalArgumentException ex){
                        System.out.println(ex.getMessage());
                    }
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
        double tankCapacity = Double.parseDouble(data[3]);
        switch (type) {
            case "Car":
                return new Car(fuelQuantity, fuelConsumption, tankCapacity);
            case "Truck":
                return new Truck(fuelQuantity, fuelConsumption,tankCapacity);
            case "Bus":
                return new Bus(fuelQuantity, fuelConsumption,tankCapacity);
            default:
                throw new IllegalArgumentException("Missing car");
        }
    }
}


package DefiningClassesExercises.RawData.SpeedRacing;

import java.awt.image.ImageProducer;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Car> map = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");

            String model = input[0];
            double fuelAmount = Double.parseDouble(input[1]);
            double fuelCostPer1Km = Double.parseDouble(input[2]);

            Car car = new Car(model, fuelAmount, fuelCostPer1Km);

            map.put(model, car);
        }

                String command = scanner.nextLine();

                while (!command.equals("End")) {
                    String[] commandLine = command.split(" ");

                    String modelCar = commandLine[1];
                    int distance = Integer.parseInt(commandLine[2]);


                    Car carToDrive = map.get(modelCar);
                    double fuelRequired = carToDrive.getFuelPer1Km() * distance;

                    if (fuelRequired <= carToDrive.getFuelAmount()) {

                        carToDrive.setFuelAmount(carToDrive.getFuelAmount() - fuelRequired);

                        carToDrive.setDistance(carToDrive.getDistance() + distance);

                    } else {
                        System.out.println("Insufficient fuel for the drive");
                    }


                    command = scanner.nextLine();
                }

                map.values().stream().forEach(System.out::println);

            }
        }


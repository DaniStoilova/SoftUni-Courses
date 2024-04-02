package ExamPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class KAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        ArrayDeque<Long> licence = Arrays.stream(scanner.nextLine().split(", "))
                .map(Long::parseLong)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Long> cars = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", "))
                .map(Long::parseLong).forEach(cars::push);

        // 1 cars = 2 * licence;

        long countCars = 0;
        long countDays = 0;

        while (!licence.isEmpty() || !cars.isEmpty()) {
            long numPlate = licence.peek();
            long numCar = cars.peek();

            if (numPlate == numCar * 2) {

                countCars += numCar;

            } else if (numCar * 2 > numPlate) {

                countCars += numPlate / 2;

                cars.add(numCar - numPlate / 2);


            } else if (numCar < numPlate) {

                countCars += numCar;

                licence.addLast(numPlate - numCar * 2);


            }

            licence.poll();
            cars.pop();
            countDays++;

            if (licence.isEmpty() || cars.isEmpty()) {
                break;
            }


        }
        System.out.printf("%d cars were registered for %d days!%n", countCars, countDays);

        if (licence.isEmpty() && cars.isEmpty()) {
            System.out.println("Good job! There is no queue in front of the KAT!");
        } else {
            if (licence.size() != 0) {
                int sum = 0;
                for (Long num : licence) {
                    sum += num;
                }
                System.out.printf("%d license plates remain!", sum);
            } else if (cars.size() != 0) {
                int sum = 0;
                for (Long num : cars) {
                    sum += num;
                }
                System.out.printf("%d cars remain without license plates!", sum);

            }
        }


    }
}

package SetsAndMapsAdvancedLab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Set<String> set = new LinkedHashSet<>();
        while (!input.equals("END")) {

            String[] parkingInfo = input.split(", ");


            String command = parkingInfo[0];
            String registrationNumber = parkingInfo[1];

            if (command.equals("IN")) {
                set.add(registrationNumber);
            } else if (command.equals("OUT")) {
                set.remove(registrationNumber);
            }


            input = scanner.nextLine();
        }

        if (set.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            System.out.println(String.join(System.lineSeparator(), set));
        }


    }
}

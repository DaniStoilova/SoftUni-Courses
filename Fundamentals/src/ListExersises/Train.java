package ListExersises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> wagonList = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());


        int capacity = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] commandLine = input.split(" ");


            if (commandLine[0].equals("Add")) {
                int passenger = Integer.parseInt(commandLine[1]);
                wagonList.add(passenger);
            } else {
                int passengerToAdd = Integer.parseInt(commandLine[0]);
                for (int i = 0; i < wagonList.size(); i++) {
                    int currentWagon = wagonList.get(i);
                    if (capacity >= passengerToAdd + currentWagon) {
                        wagonList.set(i, passengerToAdd + currentWagon);
                        break;
                    }
                }
            }


            input = scanner.nextLine();
        }
        for (int wagon : wagonList) {
            System.out.print(wagon + " ");
        }


    }
}

package ListExersises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int count = Integer.parseInt(scanner.nextLine());

        List<String> namesGuest = new ArrayList<>();

        for (int i = 1; i <= count; i++) {
            String input = scanner.nextLine();

            List<String> inputParts = Arrays.stream(input.split(" ")).collect(Collectors.toList());
            String name = inputParts.get(0);

            if (inputParts.size() == 3) {
                if (namesGuest.contains(name)) {
                    System.out.printf("%s is already in the list!%n", name);
                } else {
                    namesGuest.add(name);
                }
            } else if (inputParts.size() == 4) {
                if (namesGuest.contains(name)) {
                    namesGuest.remove(name);
                } else {
                    System.out.printf("%s is not in the list!%n", name);
                }
            }
        }
        for (String name : namesGuest) {
            System.out.println(name);
        }


    }
}

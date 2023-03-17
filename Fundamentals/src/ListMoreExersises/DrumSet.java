package ListMoreExersises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DrumSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());

        List<Integer> number = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> priceDrum = new ArrayList<>(number);

        String inputLine = scanner.nextLine();

        while (!inputLine.equals("Hit it again, Gabsy!")) {
            int power = Integer.parseInt(inputLine);

            for (int i = 0; i < number.size(); i++) {
                int element = number.get(i);

                int elementDrums = element - power;
                number.set(i, elementDrums);

                if (elementDrums <= 0) {
                    int initialQuality = priceDrum.get(i);
                    if (budget - (initialQuality * 3) >= 0) {
                        budget = budget - (initialQuality * 3);
                        number.set(i,initialQuality);
                    }else{
                        number.remove(i);
                        priceDrum.remove(i);
                        i--;
                    }
                }
            }
            inputLine = scanner.nextLine();
        }
        if (inputLine.equals("Hit it again, Gabsy!")){
            System.out.println(number.toString().replaceAll("[\\[\\]\\,]",""));
            System.out.printf("Gabsy has %.2flv.", budget);
        }

    }
}



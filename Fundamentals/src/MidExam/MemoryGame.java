package MidExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MemoryGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());

        String input = scanner.nextLine();
        int counter = 0;
        while (!input.equals("end")) {
            String[] command = input.split(" ");
            int index = Integer.parseInt(command[0]);
            int index1 = Integer.parseInt(command[1]);

            if (index >= 0 && index1 >= 0 && index < numbers.size() - 1 && index1 < numbers.size() - 1 && index != index1) {
                if (numbers.get(index) == numbers.get(index1)) {
                    numbers.remove(index);
                    numbers.remove(index1);

                    System.out.printf("Congrats! You have found matching elements - %d!", numbers.get(index));

                //} else if (numbers.get(index) != numbers.get(index1)) {
              //      System.out.println("Try again!");
                }

            } else if (index < 0 || index > numbers.size() - 1 || index > index1 || index == index1) {


                System.out.println("Invalid input! Adding additional elements to the board");

                counter++;
                String added = "-" + counter + "a";
                numbers.add(numbers.size() / 2, added);
                numbers.add(numbers.size() / 2, added);


            } else if (index1 < 0 || index1 > numbers.size() - 1 || index1 > index || index == index1) {

                System.out.println("Invalid input! Adding additional elements to the board");

                counter++;
                String added = "-" + counter + "a";
                numbers.add(numbers.size() / 2, added);
                numbers.add(numbers.size() / 2, added);



            }

            input = scanner.nextLine();
        }
    }
}

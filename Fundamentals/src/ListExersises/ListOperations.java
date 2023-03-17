package ListExersises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> number = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            List<String> commandLine = Arrays.stream(input.split(" ")).collect(Collectors.toList());
            String command = commandLine.get(0);

            if (command.contains("Add")) {
                int numberAdd = Integer.parseInt(commandLine.get(1));
                number.add(numberAdd);
            } else if (command.contains("Insert")) {
                int numToInsert = Integer.parseInt(commandLine.get(1));
                int index = Integer.parseInt(commandLine.get(2));
                if (isIndexValid(index, number.size())) {
                    number.add(index, numToInsert);
                } else {
                    System.out.println("Invalid index");
                }
            } else if (command.contains("Remove")) {
                int indexToRemove = Integer.parseInt(commandLine.get(1));
                if (isIndexValid(indexToRemove, number.size())) {
                    number.remove(indexToRemove);
                } else {
                    System.out.println("Invalid index");
                }

            } else if (command.contains("Shift")) {
                if (commandLine.get(1).contains("left")) {
                    int countLeft = Integer.parseInt(commandLine.get(2));

                    for (int i = 1; i <= countLeft; i++) {
                        int firstNumber = number.get(0);
                        number.add(firstNumber);
                        number.remove(0);

                    }
                } else if (commandLine.get(1).contains("right")) {

                    int countRight = Integer.parseInt(commandLine.get(2));

                    for (int i = 1; i <= countRight; i++) {
                        int lastNumber = number.get(number.size() - 1);
                        number.add(0, lastNumber);
                        number.remove(number.size() - 1);

                    }
                }
            }
            input = scanner.nextLine();
        }
            for (int num:number) {
                System.out.print(num + " ");
        }

        }



    private static boolean isIndexValid(int index,int size){
        return index >= 0 && index <= size - 1;
    }

}

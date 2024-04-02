package GenericsExercises.CustomListSorter.CustomListSorter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        CustomList<String> listCustom = new CustomList<>();

        while (!input.equals("END")) {
            String[] command = input.split(" ");

            String commandLine = command[0];

            switch (commandLine) {
                case "Add":
                    String elementToAdd = command[1];
                    listCustom.add(elementToAdd);
                    break;
                case "Remove":
                    int index = Integer.parseInt(command[1]);
                    listCustom.remove(index);
                    break;
                case "Contains":
                    String elementContains = command[1];
                    listCustom.contains(elementContains);
                    break;
                case "Swap":
                    int first = Integer.parseInt(command[1]);
                    int second = Integer.parseInt(command[2]);
                    listCustom.swap(first, second);
                    break;
                case "Greater":
                    String elementToSearch = command[1];
                    System.out.println(listCustom.countGreater(elementToSearch));
                    break;
                case "Max":
                    System.out.println(listCustom.getMax());
                    break;
                case "Min":
                    System.out.println(listCustom.getMin());
                    break;
                case "Sort":
                     Sorter.sort(listCustom);
                    break;
                case "Print":
                    System.out.println(listCustom);
                    break;


            }


            input = scanner.nextLine();
        }


    }
}

package IteratorsAndComparatorsExercises.ListyIterator.ListyIterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ListIterator listIterator = null;

        while (!input.equals("END")) {
            String[] commandLine = input.split(" ");
            String command = commandLine[0];
            switch (command) {
                case "Create":
                    if (commandLine.length > 1) {
                        String[] elements = Arrays.copyOfRange(commandLine, 1, commandLine.length);
                        listIterator = new ListIterator(elements);
                    } else {
                        listIterator = new ListIterator();

                    }
                        break;
                        case "Move":
                            System.out.println(listIterator.move());
                            break;
                        case "HasNext":
                            System.out.println(listIterator.hasNext());
                            break;
                        case "Print":
                            try {
                                listIterator.print();
                            }catch (IllegalStateException e){
                                System.out.println(e.getMessage());
                            }
                            break;


                    }


                    input = scanner.nextLine();
            }


        }
    }

package MethodsExersises;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] number = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();


        String inputLine = scanner.nextLine();
        while (!inputLine.equals("end")) {
            String[] command = inputLine.split(" ");
            String input = command[0];

            switch (input) {
                case "exchange":
                    int exchangeIndex = Integer.parseInt(command[1]);
                    if (isValid(exchangeIndex, number.length)) {
                        number = exchange(number, exchangeIndex);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "max":
                    String evenOdd = command[1];
                    if (evenOdd.equals("even")) {
                        printMaxEvenNumber(number);
                    } else if (evenOdd.equals("odd")) {
                        printMaxOddNumber(number);
                    }
                    break;
                case "min":
                    String minEvenOrOdd = command[1];
                    if (minEvenOrOdd.equals("even")) {
                        printMinEvenNumber(number);
                    } else if (minEvenOrOdd.equals("odd")) {
                        printMinOddNumber(number);
                    }
                    break;
                case "first":
                    int count = Integer.parseInt(command[1]);
                    if (isValidCount(count, number.length)) {
                        System.out.println("Invalid count");
                        input = scanner.nextLine();
                        continue;
                    }
                    String firstEvenOrOdd = command[2];
                    if (firstEvenOrOdd.equals("even")) {
                        printFirstEven(number, count);
                    } else if (firstEvenOrOdd.equals("odd")) {
                        printFirstOdd(number, count);
                    }
                    break;
                case "last":
                    int countLast = Integer.parseInt(command[1]);
                    if (isValidCount(countLast, number.length)) {
                        System.out.println("Invalid count");
                        input = scanner.nextLine();
                        continue;
                    }
                    String lastEvenOrOdd = command[2];
                    if (lastEvenOrOdd.equals("even")) {
                        printLastEven(number, countLast);
                    } else if (lastEvenOrOdd.equals("odd")) {
                        printLastOdd(number, countLast);
                    }
                    break;

            }


            inputLine = scanner.nextLine();
        }
        System.out.println();
        System.out.print("[");

        for (int i = 0; i <= number.length - 1; i++) {
            if (i == number.length - 1) {
                System.out.print(number[i]);
            } else {
                System.out.print(number[i] + ", ");
            }

        }
        System.out.print("]");
    }

    private static void printLastOdd(int[] number, int countLast) {
        String lastNumber = "";
        for (int i = number.length - 1; i >= 0; i--) {
            int currentNumber = number[i];
            if (currentNumber % 2 == 1) {
                lastNumber += currentNumber;
                countLast--;
            }
            if (countLast == 0) {
                break;
            }
        }
        System.out.print("[");
        for (int i = lastNumber.length() - 1; i >= 0; i++) {
            if (i == 0) {
                System.out.print(lastNumber.charAt(i));
            } else {
                System.out.print(lastNumber.charAt(i) + ", ");
            }


        }
        System.out.print("]");
    }


    private static boolean isValidCount(int count, int length) {
        return count <= length;
    }

    private static void printLastEven(int[] number, int countLast) {
        String lastNumber = "";
        for (int i = number.length - 1; i >= 0; i--) {
            int currentNumber = number[i];
            if (currentNumber % 2 == 0) {
                lastNumber += currentNumber;
                countLast--;
            }
            if (countLast == 0) {
                break;
            }
        }
        System.out.print("[");
        for (int i = lastNumber.length() - 1; i >= 0; i++) {
            if (i == 0) {
                System.out.print(lastNumber.charAt(i));
            } else {
                System.out.print(lastNumber.charAt(i) + ", ");
            }


        }
        System.out.print("]");
    }

    private static void printFirstOdd(int[] number, int count) {
        StringBuilder output = new StringBuilder();
        output.append("[");
        for (int i = 0; i <= number.length - 1; i++) {
            int currentNumber = number[i];
            if (currentNumber % 2 == 1) {
                output.append(currentNumber);
                if (count != 0) {
                    output.append(", ");
                }
                count--;
            }
            if (count == 0) {

                break;
            }

        }

        output.append("]");
        System.out.println(output.toString());
    }

    private static void printFirstEven(int[] number, int count) {
        StringBuilder output = new StringBuilder();
        output.append("[");
        for (int i = 0; i <= number.length - 1; i++) {
            int currentNumber = number[i];
            if (currentNumber % 2 == 0) {
                output.append(currentNumber);
                if (count != 0) {
                    output.append(", ");
                }
                count--;
            }
            if (count == 0) {

                break;
            }

        }

        output.append("]");
        System.out.println(output.toString());


    }

    private static void printMinOddNumber(int[] number) {
        int min = Integer.MAX_VALUE;
        int indexMin = -1;
        for (int i = 0; i <= number.length - 1; i++) {
            int currentNumber = number[i];
            if (currentNumber % 2 == 1 && currentNumber <= min) {
                min = currentNumber;
                indexMin = i;
            }
        }
        if (indexMin == -1) {
            System.out.println("No matches");
        } else {
            System.out.println(indexMin);
        }
    }

    private static void printMinEvenNumber(int[] number) {
        int min = Integer.MAX_VALUE;
        int indexMin = -1;
        for (int i = 0; i <= number.length - 1; i++) {
            int currentNumber = number[i];
            if (currentNumber % 2 == 0 && currentNumber <= min) {
                min = currentNumber;
                indexMin = i;
            }
        }
        if (indexMin == -1) {
            System.out.println("No matches");
        } else {
            System.out.println(indexMin);
        }

    }


    private static void printMaxOddNumber(int[] number) {
        int max = Integer.MIN_VALUE;
        int indexMax = -1;
        for (int i = 0; i <= number.length - 1; i++) {
            int currentNumber = number[i];
            if (currentNumber % 2 == 1 && currentNumber >= max) {
                max = currentNumber;
                indexMax = i;
            }
        }
        if (indexMax == -1) {
            System.out.println("No matches");
        } else {
            System.out.println(indexMax);
        }
    }

    private static void printMaxEvenNumber(int[] number) {
        int max = Integer.MIN_VALUE;
        int indexMax = -1;
        for (int i = 0; i <= number.length - 1; i++) {
            int currentNumber = number[i];
            if (currentNumber % 2 == 0 && currentNumber >= max) {
                max = currentNumber;
                indexMax = i;
            }
        }
        if (indexMax == -1) {
            System.out.println("No matches");
        } else {
            System.out.println(indexMax);
        }
    }

    private static int[] exchange(int[] numbers, int exchangeIndex) {
        int[] numbersToExchangeIndex = new int[exchangeIndex + 1];
        int[] numberAfter = new int[numbers.length - exchangeIndex - 1];

        for (int i = 0; i <= exchangeIndex; i++) {
            int currentElement = numbers[i];
            numbersToExchangeIndex[i] = currentElement;

        }
        for (int i = exchangeIndex + 1; i <= numbers.length - 1; i++) {
            int currentNumber = numbers[i];
            numberAfter[i - exchangeIndex - 1] = currentNumber;
        }
        int newExchangeArray[] = new int[numbers.length];
        for (int i = 0; i <= numberAfter.length - 1; i++) {
            newExchangeArray[i] = numberAfter[i];
        }
        for (int i = numberAfter.length; i <= newExchangeArray.length - 1; i++) {
            newExchangeArray[i] = numbersToExchangeIndex[i - numberAfter.length];
        }
        return newExchangeArray;

    }

    private static boolean isValid(int index, int length) {
        return index >= 0 && index < length - 1;
    }
}

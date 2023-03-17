package ArraysExersises;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] command = input.split(" ");
            String commandType = command[0];

            switch (commandType) {
                case "swap":
                    int index1 = Integer.parseInt(command[1]);
                    int elements1 = numbers[index1];
                    int index2 = Integer.parseInt(command[2]);
                    int elements2 = numbers[index2];

                    numbers[index1]=elements2;
                    numbers[index2]=elements1;

                    break;
                case "multiply":
                    int indexMultiply1 = Integer.parseInt(command[1]);
                    int elementsMultiply = numbers[indexMultiply1];
                    int indexMultiply2 = Integer.parseInt(command[2]);
                    int elementsMultiply2 = numbers[indexMultiply2];
                    int product = elementsMultiply * elementsMultiply2;
                     numbers[indexMultiply1] = product;

                    break;
                case "decrease":
                    for (int i = 0; i <= numbers.length -1 ; i++) {
                       numbers[i] = numbers[i] -1;
                    }

                    break;
            }

            input = scanner.nextLine();
        }
        for (int i = 0; i <= numbers.length -1; i++) {
            if ( i != numbers.length - 1){
                System.out.print(numbers[i] + ", ");
            }else{
                System.out.print(numbers[i]);
            }
        }

    }
}

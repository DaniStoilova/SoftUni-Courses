package ArraysExersises;

import java.util.Arrays;
import java.util.Scanner;

public class EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int index = 0; index <= array.length - 1; index++) {
            int currentElement = array[index];

            int sumLeft = 0;
            int sumRight = 0;

            for (int leftElement = 0; leftElement < index; leftElement++) {
                sumLeft += array[leftElement];
            }
            for (int rightElements = index + 1; rightElements <= array.length -1 ; rightElements++) {
                sumRight += array[rightElements] ;
            }

            if (sumLeft == sumRight){
                System.out.println(index);
                return;
            }
        }

        System.out.println("no");

    }
}

package ArraysExersises;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();


        int counter = 1;
        int maxSequence = 0;
        int elements = 0;
        for (int i = 0; i < numbers.length -1; i++) {
            if (numbers[i] == numbers[i + 1]){
                counter++;
            }else{
                counter = 1;
            }

            if ( maxSequence < counter){
                maxSequence = counter;
                elements = numbers[i];
            }

        }
        for (int i = 0; i < maxSequence; i++) {
            System.out.print(elements + " ");
        }

    }
}

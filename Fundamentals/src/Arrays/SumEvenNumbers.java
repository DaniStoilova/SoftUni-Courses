package Arrays;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class SumEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputLine = scanner.nextLine();

        int[] num = Arrays
                .stream(inputLine.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

//        String[] value = inputLine.split(" ");
//
//        int[] num = new int[value.length];


        int sum = 0;
        for (int i = 0; i < num.length; i++) {
            int currentEl = num[i];

            //num[i] % 2 == 0
            if (currentEl % 2 == 0) {

                //sum += num[i];

                sum += currentEl;
            }

        }

        System.out.println(sum);


    }
}

package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class CondenseArrayToNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numArr = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        while (numArr.length > 1){
            int[] newArr = new int[numArr.length - 1];
            for (int i = 0; i < numArr.length - 1; i++) {
                newArr[i] = numArr[i] + numArr [i + 1];
            }
            numArr = newArr;
        }
        System.out.println(numArr[0]);
        }

    }




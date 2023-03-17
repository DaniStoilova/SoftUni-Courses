package Arrays;

import java.util.Scanner;

public class EvenAndOddSubtraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arr = scanner.nextLine().split(" ");

        int[] numArr = new int[arr.length];

        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = Integer.parseInt(arr[i]);

        }
        int even = 0;
        int odd = 0;
        for (int num : numArr) {
            if (num % 2 == 0) {
                even += num;
            } else {
                odd += num;
            }
        }
//        for (int i = 0; i < numArr.length; i++) {
//            if(numArr[i] % 2 == 0){
//                even += numArr[i];
//            }else{
//                odd += numArr[i];
//            }
//        }

        int diff = even - odd;
        System.out.println(diff);
    }
}

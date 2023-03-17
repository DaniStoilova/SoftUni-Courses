package TextProcessingExercise;

import java.math.BigInteger;
import java.util.Scanner;

public class MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigInteger firstNumber = new BigInteger(scanner.nextLine());
        BigInteger secondNumber = new BigInteger(scanner.nextLine());


        System.out.println(firstNumber.multiply(secondNumber));

//        String number = scanner.nextLine();
//        int second = Integer.parseInt(scanner.nextLine());
//
//        StringBuilder bd = new StringBuilder();
//
//        for (int i = number.length() -1; i >= 0; i--) {
//            char symbol = (char) Integer.parseInt(String.valueOf(number.charAt(i)));
//
//            bd.append(symbol * second);

            //bd.reverse();



        }
//        System.out.println(bd.reverse());
//
//    }
}

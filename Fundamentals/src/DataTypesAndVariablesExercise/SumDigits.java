package DataTypesAndVariablesExercise;

import java.util.Scanner;

public class SumDigits {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        while (number != 0){

          int lastDigit = number % 10;

            sum += lastDigit;

            number = number/10;
        }
        System.out.printf("%d",sum);

    }
}

// String num = scanner.nextLine();
//int sum = 0;
//for (int i = 0; i <= num.length() - 1 ; i++) {
//    char n = num.charAt(i);
//}
//  int number = Integer.parseInt(String.valueOf(n);
// sum += number;
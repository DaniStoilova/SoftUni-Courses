package MethodsExersises;

import java.util.Scanner;

public class AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        int thirdNum = Integer.parseInt(scanner.nextLine());


        int sum = calculateAdd(firstNum,secondNum);
        int result = calculateSubtract(sum,thirdNum);

        System.out.println(result);




    }
    private static int calculateAdd(int firstNumber,int secondNumber){
        int sum = firstNumber + secondNumber;

        return sum;
    }
    private static int calculateSubtract (int sum, int thirdNumber){

        int result = sum - thirdNumber;

        return result;

    }

}

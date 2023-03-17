package ArraysExersises;

import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

    int n = Integer.parseInt(scanner.nextLine());
    String [] firstArr = new String[n];
    String [] secondArr = new String[n];



        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String firstNumber = input.split(" ")[0];
            String secondNumber = input.split(" ")[1];

            if((i + 1) % 2 == 1){
                firstArr[i] = firstNumber;
                secondArr[i] = secondNumber;
            }else{
                firstArr[i] = secondNumber;
                secondArr[i] = firstNumber;
            }
        }
        for (String element:firstArr) {
            System.out.print(element + " ");
        }
            System.out.println();
        for (String element:secondArr) {
            System.out.print(element + " ");
        }

    }
}

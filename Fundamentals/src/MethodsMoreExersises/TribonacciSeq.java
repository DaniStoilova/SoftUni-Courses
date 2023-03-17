package MethodsMoreExersises;

import java.util.Scanner;

public class TribonacciSeq {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 2; i <= n + 1; i++) {
            if (i == 0 && i == 1){

            }

          i = (i - 1 + i - 2);

            System.out.print(n - 1 + " ");
        }


    }
}

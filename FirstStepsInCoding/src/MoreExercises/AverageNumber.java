package MoreExercises;

import java.util.Scanner;

public class AverageNumber {
    public static void  main(String[]args){
        Scanner scanner = new Scanner(System.in);

    int n = Integer.parseInt(scanner.nextLine());
    int sum = 0;
    for (int i=1; i <= n; i++){
        int m = Integer.parseInt(scanner.nextLine());

        sum += m;



    }

    System.out.printf("%.2f", sum * 1.0/n);



    }
}

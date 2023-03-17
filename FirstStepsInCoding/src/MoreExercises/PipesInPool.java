package MoreExercises;

import java.util.Scanner;

public class PipesInPool {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int v = Integer.parseInt(scanner.nextLine());
        int p1 = Integer.parseInt(scanner.nextLine());
        int p2 = Integer.parseInt(scanner.nextLine());
        double h = Double.parseDouble(scanner.nextLine());

        double p1Debit = p1 * h;
        double p2Debit = p2 * h;
        double totalDebit = p1Debit + p2Debit;
        double debitPercent = totalDebit/v * 100.00;

        double p1Percent = p1Debit/totalDebit * 100.00;
        double p2Percent = p2Debit/totalDebit * 100.00;
        double diff = Math.abs(totalDebit - v);
        if (totalDebit <= v) {
            System.out.printf("The pool is %.2f%% full. Pipe 1: %.2f%%. Pipe 2:%n%.2f%%.", debitPercent, p1Percent, p2Percent);
        }else{
            System.out.printf("For %.2f hours the pool overflows with %.2f%nliters.",h, diff);
        }

    }
}

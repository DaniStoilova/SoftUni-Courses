package MoreExercises;

import java.util.Scanner;

public class OddEvenPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        double sumOdd = 0;
        double sumEven = 0;
        double maxOdd = Double.MIN_VALUE;
        double minOdd = Double.MAX_VALUE;
        double maxEven = Double.MIN_VALUE;
        double minEven = Double.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            double number = Double.parseDouble(scanner.nextLine());

            if (i % 2 == 0) {
                sumEven += number;
                if (maxEven < number || maxEven > number){
                    maxEven = number;
                }else if(maxEven > 0){
                    System.out.println("EvenMax=No");
                }
                if (minEven > number) {
                    minEven = number;
                }

            } else if (i % 2 != 0) {
                sumOdd += number;
                if (maxOdd < number || maxOdd > number) {
                    maxOdd = number;
                }
                if (minOdd > number) {
                    minOdd = number;

                }
            }

            }
        System.out.printf("OddSum=%.2f,%n", sumOdd);
        System.out.printf("OddMin=%.2f,%n", minOdd);
        System.out.printf("OddMax=%.2f,%n", maxOdd);
        System.out.printf("EvenSum=%.2f,%n", sumEven);
        System.out.printf("EvenMin=%.2f,%n", minEven);
        System.out.printf("EvenMax=%.2f%n", maxEven);


    }
    }



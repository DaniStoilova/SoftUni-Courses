package MethodsMoreExersises;

import java.util.Scanner;


public class DataType {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        switch (input){
            case "int":
                int number = Integer.parseInt(scanner.nextLine());
               printResult(number);
                break;
            case "real":
                double num = Double.parseDouble(scanner.nextLine());
                printResult(num);
                break;
            case "string":
                String type = scanner.nextLine();
                printResult(type);
                break;
        }
    }
    private static void printResult(int number){
        int result = number * 2;
        System.out.println((result));
    }
    private static void printResult(double number){
        double result = number * 1.5;
        System.out.printf("%.2f",result);
    }
    private static void printResult(String type){
        System.out.println("$"+type+"$");

    }

}

package Methods;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        double firstNum = Double.parseDouble(scanner.nextLine());
        String operations = scanner.nextLine();
        double secondNum = Double.parseDouble(scanner.nextLine());

        DecimalFormat df = new DecimalFormat("0.####");
                System.out.print(df.format(calculateMathOperators(firstNum,operations,secondNum)));

    }


    public static double calculateMathOperators(double first, String operations, double second) {
        double result = 0.0;

        switch (operations) {
            case "*":
                result = first * second;
                break;
            case "+":
                result = first + second;
                break;
            case "-":
                result = first - second;
                break;
        }
        return  result;
    }
}




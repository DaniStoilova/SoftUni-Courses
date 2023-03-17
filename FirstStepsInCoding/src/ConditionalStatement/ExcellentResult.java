package ConditionalStatement;

import java.util.Scanner;

public class ExcellentResult {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int grade = Integer.parseInt(scanner.nextLine());
        boolean IsExcellent = grade >= 5;
        if (grade >= 5){
            System.out.println("Excellent!");

        }
    }
}

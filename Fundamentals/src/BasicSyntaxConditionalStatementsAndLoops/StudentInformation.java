package BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class StudentInformation {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        //student name, age and average grade

        String studentName = scanner.nextLine();
        int age =  Integer.parseInt(scanner.nextLine());
        double averageGrade = Double.parseDouble(scanner.nextLine());

        System.out.printf("Name: %s, Age: %d, Grade: %.2f%n",studentName,age, averageGrade);


    }
}

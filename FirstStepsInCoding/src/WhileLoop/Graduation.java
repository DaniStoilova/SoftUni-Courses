package WhileLoop;

import java.util.Scanner;

public class Graduation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();


        int grade = 1;
        int poorGrade = 0;
        double allGrades = 0;
        while (grade <= 12) {
            if (poorGrade == 2){
                break;
            }
            double yearGrade = Double.parseDouble(scanner.nextLine());
            if (yearGrade < 4) {
                poorGrade++;
                continue;
            }
            allGrades += yearGrade;
            grade++;

        }
        if (grade > 12 ){
            System.out.printf("%s graduated. Average grade: %.2f", name, allGrades/12);
        }else{
            System.out.printf("%s has been excluded at %d grade", name, grade);
        }



    }
}

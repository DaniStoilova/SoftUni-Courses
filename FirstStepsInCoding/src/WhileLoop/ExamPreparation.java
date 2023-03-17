package WhileLoop;

import java.util.Scanner;

public class ExamPreparation {
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);

        int poorGrade = Integer.parseInt(scanner.nextLine());

        int poor = 0;
        int countTask = 0;
        String task = "";
        double gradeSum = 0;

        String nameTask = scanner.nextLine();
        while (!nameTask.equals("Enough")){
            int grade = Integer.parseInt(scanner.nextLine());

            if (grade <= 4){
                poor ++;
            if (poor >= poorGrade){
                break;
            }

            }
             gradeSum+= grade;
            countTask++;
            task = nameTask;


            nameTask = scanner.nextLine();

        }
        if(nameTask.equals("Enough")){
            System.out.printf("Average score: %.2f%n", gradeSum/countTask);
            System.out.printf("Number of problems: %d%n", countTask);
            System.out.printf("Last problem: %s%n", task);
        }else{
            System.out.printf("You need a break, %d poor grades.", poor);
        }
    }
}

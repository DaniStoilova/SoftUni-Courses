package ObjectAndClassesExersises;

import java.util.*;

public class Students {
    static class Student {

        private String firstName;
        private String secondName;
        private double grade;

        public Student(String firstName, String secondName, double grade) {
            this.firstName = firstName;
            this.secondName = secondName;
            this.grade = grade;


        }

        public double getGrade() {
            return this.grade;
        }

        public String getSecondName() {
            return this.secondName;
        }

        public String getFirstName() {
            return this.firstName;
        }

        @Override
        public String toString(){
            return String.format("%s %s: %.2f",this.firstName,this.secondName,this.grade);
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Student> studentList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String[] personalDate = scanner.nextLine().split(" ");
            String firstName = personalDate[0];
            String secondName = personalDate[1];
            double grade = Double.parseDouble(personalDate[2]);

            Student student = new Student(firstName, secondName, grade);
            studentList.add(student);

        }
        studentList.sort(Comparator.comparingDouble(Student::getGrade).reversed());

        for (Student student : studentList) {
            //System.out.printf("%s %s: %.2f%n",student.getFirstName(),student.getSecondName(),student.getGrade());
            System.out.println(student.toString());
        }


    }
}

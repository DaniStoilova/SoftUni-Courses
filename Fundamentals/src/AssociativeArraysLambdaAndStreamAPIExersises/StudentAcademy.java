package AssociativeArraysLambdaAndStreamAPIExersises;

import java.util.*;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> map = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String studentsName = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

        if(!map.containsKey(studentsName)){

            map.put(studentsName,new ArrayList<>());

        }
            map.get(studentsName).add(grade);




        }
        Map<String,Double> averageGrade = new LinkedHashMap<>();

        for (Map.Entry<String, List<Double>> entry : map.entrySet()) {
            String studentsName = entry.getKey();
            List<Double> grades = entry.getValue();
            double average = getAverageGrade(grades);
            if (average >= 4.50) {
                averageGrade.put(studentsName, average);
            }
        }
         averageGrade.entrySet().forEach(entry ->
            System.out.printf("%s -> %.2f%n",entry.getKey(),entry.getValue()));
        }



    private static double getAverageGrade(List<Double> grades) {
            double sum = 0;
        for (double grade:grades) {
            sum += grade;
        }
        return sum/grades.size();
    }
}

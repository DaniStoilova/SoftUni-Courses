package AssociativeArraysLambdaAndStreamAPIExersises;

import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, List<String>> map = new LinkedHashMap<>();

        while (!input.equals("end")) {
            String[] line = input.split(" : ");
            String courseName = line[0];
            String studentName = line[1];

            if (!map.containsKey(courseName)) {
                map.put(courseName, new ArrayList<>());
                map.get(courseName).add(studentName);
            } else {

                map.get(courseName).add(studentName);


            }
            input = scanner.nextLine();
        }
//
//        map.entrySet().forEach(entry -> { System.out.printf("%s: %s%n", entry.getKey(), entry.getValue().size());
//        entry.getValue().forEach(studentName -> System.out.printf("--%s%n",studentName));
//
//    });

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            System.out.println(entry.getKey()+": " + entry.getValue().size());
            entry.getValue().forEach(studentName -> System.out.printf("-- %s%n",studentName));
        }

    }

}

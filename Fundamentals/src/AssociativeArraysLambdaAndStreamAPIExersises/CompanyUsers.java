package AssociativeArraysLambdaAndStreamAPIExersises;

import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();
        LinkedHashMap<String, List<String>> map = new LinkedHashMap<>();

        while (!input.equals("End")) {
            String[] data = input.split(" -> ");
            String companyName = data[0];
            String id = data[1];

            if (map.containsKey(companyName)) {
                List<String> employees = map.get(companyName);

                if (!employees.contains(id))
                    employees.add(id);
                } else {
                    List<String> employer = new ArrayList<>();
                    employer.add(id);
                    map.put(companyName, employer);
                }
            input = scanner.nextLine();
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            System.out.printf("%s%n", entry.getKey());
            entry.getValue().forEach(employer -> System.out.printf("-- %s%n", employer));
        }
    }
}

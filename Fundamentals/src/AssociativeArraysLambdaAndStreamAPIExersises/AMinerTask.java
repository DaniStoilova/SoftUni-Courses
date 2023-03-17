package AssociativeArraysLambdaAndStreamAPIExersises;

import java.util.*;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String resource = scanner.nextLine();

        Map<String, Integer> map = new LinkedHashMap<>();

        while (!resource.equals("stop")) {
            int quantity = Integer.parseInt(scanner.nextLine());

            if (!map.containsKey(resource)){
                map.put(resource,quantity);
            }else{
                int currentQuantity = map.get(resource);
                map.put(resource,currentQuantity + quantity);
            }


                resource = scanner.nextLine();
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(),entry.getValue());
        }

    }
}

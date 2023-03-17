package AssociativeArraysLambdaAndStreamAPIExersises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String,Double> mapPrice = new LinkedHashMap<>();

        Map<String,Integer> mapQuantity = new LinkedHashMap<>();

        while (!input.equals("buy")){
            String[] line = input.split(" ");
            String product = line[0];
            double price = Double.parseDouble(line[1]);
            int quantity = Integer.parseInt(line[2]);

            mapPrice.put(product,price);

        if(!mapQuantity.containsKey(product)){
           mapQuantity.put(product,quantity);

        }else{
            int value = mapQuantity.get(product);
            mapQuantity.put(product,value + quantity);

        }

            input = scanner.nextLine();
        }
        for (Map.Entry<String, Double> entry : mapPrice.entrySet()) {
            String productName = entry.getKey();
            double sum = entry.getValue() * mapQuantity.get(productName);
            System.out.printf("%s -> %.2f%n",productName,sum);
        }


    }
}

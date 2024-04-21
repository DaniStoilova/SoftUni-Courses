package EncapsulationExercise.ShoppingSpree.ShoppingSpree;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] data = scanner.nextLine().split(";");

        Map<String,Person> map = new LinkedHashMap<>();

        for (String people : data) {
            String[] personData = people.split("=");
            String name = personData[0];
            double money = Double.parseDouble(personData[1]);

            try{
                Person person = new Person(name,money);
                map.put(name,person);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                return;
            }

        }
        String [] products = scanner.nextLine().split(";");
        Map<String,Product> mapProduct = new LinkedHashMap<>();

        for (String productS : products) {
            String[] productData = productS.split("=");
            String name = productData[0];
            double cost = Double.parseDouble(productData[1]);


            try{
                Product product = new Product(name,cost);
                mapProduct.put(name,product);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                return;
            }
        }
        String input = scanner.nextLine();
        while (!input.equals("END")){
            String [] inputLine = input.split(" ");
            String personName = inputLine[0];
            String productName = inputLine[1];

            Person buyer = map.get(personName);
            Product product = mapProduct.get(productName);

            try {
                buyer.buyProduct(product);
                System.out.printf("%s bought %s%n",personName,productName);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }



            input = scanner.nextLine();
        }
        map.values().forEach(System.out::println);










    }
}

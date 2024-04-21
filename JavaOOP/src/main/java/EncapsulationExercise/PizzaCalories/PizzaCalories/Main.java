package EncapsulationExercise.PizzaCalories.PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String []data = scanner.nextLine().split(" ");
        String namePizza = data[1];
        int numOfToppings = Integer.parseInt(data[2]);

        String []dataDough = scanner.nextLine().split(" ");
        String flourType = dataDough[1];
        String backing = dataDough[2];
        double weight = Double.parseDouble(dataDough[3]);


        try {
            Pizza pizza = new Pizza(namePizza, numOfToppings);
            Dough dough = new Dough(flourType,backing,weight);
            pizza.setDough(dough);
            String input = scanner.nextLine();
            while (!input.equals("END")){
                String []toppingInfo = input.split(" ");
                String name = toppingInfo[1];
                double toppingWeight =Double.parseDouble(toppingInfo[2]);

                Topping toppings = new Topping(name,toppingWeight);
                pizza.addTopping(toppings);

                input = scanner.nextLine();

            }
            System.out.printf("%s - %.2f%n",pizza.getName(),pizza.getOverallCalories());
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }






    }
}

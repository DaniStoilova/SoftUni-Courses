package EncapsulationExercise.PizzaCalories.PizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dought;
    private List<Topping> toppings;

    public Pizza(String name, int countOfToppings) {
        setName(name);
        setToppings(countOfToppings);
    }

    private void setName(String name) {
        if (name.trim().isEmpty() || name.length() > 15){
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    public void setDough(Dough dough) {
        this.dought = dough;
    }

    private void setToppings(int countOfToppings) {
        if (countOfToppings < 0 || countOfToppings > 10){
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.toppings = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public void addTopping (Topping topping){
        toppings.add(topping);

    }
    public double getOverallCalories (){
        return dought.calculateCalories() + toppings.stream().mapToDouble(Topping::calculateCalories).sum();

    }
}

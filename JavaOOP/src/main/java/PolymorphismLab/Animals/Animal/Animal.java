package PolymorphismLab.Animals.Animal;

public abstract class Animal {
    //•	name: String
    //•	favouriteFood: String
    private String name;
    private String favouriteFood;

    public Animal(String name, String favouriteFood) {
        this.name = name;
        this.favouriteFood = favouriteFood;
    }
    public  String explainSelf(){
        return String.format("I am %s and my favourite food is %s",name,favouriteFood);
    }


}

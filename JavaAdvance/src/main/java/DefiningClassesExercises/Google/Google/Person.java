package DefiningClassesExercises.Google.Google;

import java.util.List;

public class Person {
    private String name;
    private List<Pokemon> pokemonList;
    private List<Parents> parentsList;
    private List<Children> childrenList;
    private Car car;
    private Company company;

    public Person(String name, List<Pokemon> pokemonList, List<Parents> parentsList,
                  List<Children> childrenList) {
        this.name = name;
        this.pokemonList = pokemonList;
        this.parentsList = parentsList;
        this.childrenList = childrenList;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public void setPokemonList(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }

    public List<Parents> getParentsList() {
        return parentsList;
    }

    public void setParentsList(List<Parents> parentsList) {
        this.parentsList = parentsList;
    }

    public List<Children> getChildrenList() {
        return childrenList;
    }

    public void setChildrenList(List<Children> childrenList) {
        this.childrenList = childrenList;
    }

    public Car getCar(Car car) {
        return this.car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Company getCompany(Company company) {
        return this.company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void print() {
        System.out.println(name);
        System.out.println("Company:");
        if (company != null) {
            System.out.println(company.format());
        }
        System.out.println("Car:");
        if (car != null) {
            System.out.println(car.format());
        }
        System.out.println("Pokemon:");
        if(!getPokemonList().isEmpty()) {
            getPokemonList().forEach(pokemon -> System.out.printf("%s%n", pokemon.format()));
        }
        System.out.println("Parents:");
        if(!getParentsList().isEmpty()) {
            getParentsList().forEach(parent -> System.out.printf("%s%n", parent.format()));
        }
        System.out.println("Children:");
        if(!getChildrenList().isEmpty()) {
            getChildrenList().forEach(children -> System.out.printf("%s%n", children.format()));
        }
    }

}


package DefiningClassesExercises.Google.Google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String,Person> map = new HashMap<>();

        Person person = null;

        while (!input.equals("End")) {

            String[] data = input.split(" ");
            String name = data[0];
            String command = data[1];

            map.putIfAbsent(name,new Person(name,new ArrayList<>(),new ArrayList<>()
                    ,new ArrayList<>()));

            switch (command) {
                case "company":
                    String companyName = data[2];
                    String department = data[3];
                    double salary = Double.parseDouble(data[4]);

                    Company company = new Company(companyName,department,salary);
                    map.get(name).setCompany(company);
                    break;
                case "pokemon":
                    String pokemonName = data[2];
                    String pokemonType = data[3];

                    Pokemon pokemon = new Pokemon(pokemonName,pokemonType);
                    map.get(name).getPokemonList().add(pokemon);
                    break;
                case "parents":
                    String parentName = data[2];
                    String parentBirthday = data[3];

                    Parents parents = new Parents(parentName,parentBirthday);
                    map.get(name).getParentsList().add(parents);

                    break;
                case "children":
                    String childName = data[2];
                    String childBirthday = data[3];

                    Children children = new Children(childName,childBirthday);
                    map.get(name).getChildrenList().add(children);
                    break;
                case "car":

                    String carModel = data[2];
                    int carSpeed = Integer.parseInt(data[3]);

                    Car car = new Car(carModel,carSpeed);
                    map.get(name).setCar(car);
                    break;
            }


            input = scanner.nextLine();
        }

        String nameToSearch = scanner.nextLine();

            map.get(nameToSearch).print();





    }
}

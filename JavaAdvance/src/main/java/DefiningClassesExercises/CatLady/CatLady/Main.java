package DefiningClassesExercises.CatLady.CatLady;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        HashMap<String, Siamese> mapSiamese = new HashMap<>();
        HashMap<String, Cymric> mapCymric = new HashMap<>();
        HashMap<String, StreetExtraordinaire> mapStreet = new HashMap<>();

        while (!input.equals("End")) {
            String[] data = input.split(" ");
            String breed = data[0];
            String name = data[1];
            switch (breed) {
                case "Siamese":
                    double earSize = Double.parseDouble(data[2]);
                    Siamese siamese = new Siamese(name, earSize);
                    mapSiamese.put(name, siamese);
                    break;
                case "Cymric":
                    Double furLength = Double.parseDouble(data[2]);
                    Cymric cymric = new Cymric(name, furLength);
                    mapCymric.put(name, cymric);
                    break;
                case "StreetExtraordinaire":
                    double decibelsOfMeows = Double.parseDouble(data[2]);
                    StreetExtraordinaire streetExtraordinaire = new StreetExtraordinaire(name, decibelsOfMeows);
                    mapStreet.put(name, streetExtraordinaire);
                    break;
            }
            input = scanner.nextLine();
        }

        String nameToSearch = scanner.nextLine();

        if (mapSiamese.containsKey(nameToSearch)) {
            System.out.println(mapSiamese.get(nameToSearch));
        } else if (mapCymric.containsKey(nameToSearch)) {
            System.out.println(mapCymric.get(nameToSearch));
        } else if (mapStreet.containsKey(nameToSearch)) {
            System.out.println(mapStreet.get(nameToSearch));
        }


    }


}


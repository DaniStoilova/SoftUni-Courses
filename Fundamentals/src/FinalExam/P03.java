package FinalExam;

import java.util.*;

public class P03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> map = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] line = input.split(" ");
            String command = line[0];

            switch (command) {
                case "Enroll":
                    String comma = line[0];
                    String heroName = line[1];

                    if (!map.containsKey(heroName)) {

                        map.put(heroName, new ArrayList<>());

                    } else {
                        System.out.printf("%s is already enrolled.%n", heroName);

                    }
                    break;
                case "Learn":
                    String heroNameLearn = line[1];
                    String spellName = line[2];


                    if (!map.containsKey(heroNameLearn)) {
                        System.out.printf("%s doesn't exist.%n", heroNameLearn);

                    } else if(!map.get(heroNameLearn).contains(spellName)) {

                        map.put(heroNameLearn, new ArrayList<>());
                        map.get(heroNameLearn).add(spellName);

                    } else if (map.containsKey(heroNameLearn) && map.get(heroNameLearn).contains(spellName)) {

                        System.out.printf("%s has already learnt %s.%n", heroNameLearn, spellName);
                    }
                    break;
                case "Unlearn":
                    String heroNameUnLearn = line[1];
                    String spell = line[2];

                    if (!map.containsKey(heroNameUnLearn)) {

                        System.out.printf("%s doesn't exist.%n", heroNameUnLearn);
                    } else if (map.get(heroNameUnLearn).contains(spell)) {
                        map.get(heroNameUnLearn).remove(spell);

                    } else if (map.containsKey(heroNameUnLearn) && !map.get(heroNameUnLearn).contains(spell)){
                        System.out.printf("%s doesn't know %s.%n", heroNameUnLearn, spell);
                    }


                    break;


            }
            input = scanner.nextLine();

        }

        System.out.println("Heroes:");
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String name = entry.getKey();
            List<String> item = entry.getValue();
            if (item.size() == 0) {
                System.out.printf("== %s: %n", name);
            } else {
                System.out.printf("== %s: %s%n", name, item.get(0));
            }
        }
    }

}

